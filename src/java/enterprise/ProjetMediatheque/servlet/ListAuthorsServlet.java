/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import java.io.IOException;
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
import javax.transaction.UserTransaction;

/**
 *
 * @author guyader
 */
@WebServlet(name = "ListAuthorsServlet", urlPatterns = {"/ListAuthors"})
public class ListAuthorsServlet extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
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
        assert emf != null;
        EntityManager em = null;
        
        try {
            // Demarrage de la transaction
            utx.begin();
            
            //Creation d'un Entity Manager
            //Since the em is created inside a transaction, it is associsated with the transaction
            em = emf.createEntityManager();
            
            List auteurs = em.createQuery("SELECT a FROM Auteur a").getResultList();
            request.setAttribute("auteurs", auteurs);
            request.getRequestDispatcher("listAuthors.jsp").forward(request, response);
            
            //commit transaction which will trigger the em to 
            //commit newly created entity into database
            utx.commit();
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if(em != null) {
                em.close();
            }
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
