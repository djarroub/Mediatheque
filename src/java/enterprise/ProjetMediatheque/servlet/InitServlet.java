/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Type;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author guyader
 */
@WebServlet(name = "InitServlet", urlPatterns = {"/Init"})
public class InitServlet extends HttpServlet {

    @PersistenceUnit
    EntityManagerFactory emf;
    
    @Resource
    private UserTransaction utx;

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            utx.begin();
            em = emf.createEntityManager();
            
            Query query = em.createQuery("delete from Type t");
            query.executeUpdate();
            
            Type cd = new Type("CD", 8, 0);
            Type dvd = new Type("DVD", 3, 1);
            Type livre = new Type("LIVRE", 31, 0);
            Type revue = new Type("REVUE", 0, 0);
            Type magazine = new Type("MAGAZINE", 0, 0);
            Type cassette = new Type("CASSETTE_VIDEO", 0, 0);

            em.persist(cd);
            em.persist(dvd);
            em.persist(livre);
            em.persist(revue);
            em.persist(magazine);
            em.persist(cassette);
            utx.commit();
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if(em != null) {
                em.close();
                response.sendRedirect("librarianAccess.jsp");
            }
        }
    }
}
