/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Adherent;
import enterprise.ProjetMediatheque.entity.Ouvrage;
import enterprise.ProjetMediatheque.entity.Reservation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author guyader
 */
@WebServlet(name = "ValidateBasketServlet", urlPatterns = {"/ValidateBasket"})
public class ValidateBasketServlet extends HttpServlet {

    @PersistenceUnit
    EntityManagerFactory emf;
    
    @Resource
    private UserTransaction utx;
    

   /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("adherent") != null) {
            assert emf != null;  //Make sure injection went through correctly.
            EntityManager em = null;
            try {
                List<String> ids = (List)session.getAttribute("ids");
                if (ids == null)
                    response.sendRedirect("BrowseCatalog");
                
                utx.begin();
                em = emf.createEntityManager();
                
                List<Ouvrage> ouvrages = new ArrayList<Ouvrage>();
                for (String id : ids)
                    ouvrages.add((Ouvrage)
                            em.createNamedQuery("Ouvrage.get")
                            .setParameter("id", Long.parseLong(id))
                            .getSingleResult());
                
                for (Ouvrage o : ouvrages) {
                    Reservation reservation = new Reservation((Adherent)session.getAttribute("adherent"), o);
                    em.persist(reservation);
                }
                
                session.removeAttribute("ids");
                utx.commit();
                
                //Forward to the jsp page for rendering
                response.sendRedirect("BrowseCatalog");
            } catch (Exception ex) {
                throw new ServletException(ex);
            } finally {
                //close the em to release any resources held up by the persistence provider
                if(em != null) {
                    em.close();
                }
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
