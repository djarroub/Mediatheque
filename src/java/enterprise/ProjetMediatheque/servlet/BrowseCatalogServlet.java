/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guyader
 */
@WebServlet(name = "BrowseCatalogServlet", urlPatterns = {"/BrowseCatalog"})
public class BrowseCatalogServlet extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    
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
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("adherent") != null) {
            assert emf != null;  //Make sure injection went through correctly.
            EntityManager em = null;
            try {
                em = emf.createEntityManager();
                
                List ouvrages = em.createQuery("SELECT o FROM Ouvrage o").getResultList();
                request.setAttribute("ouvrages", ouvrages);
                request.setAttribute("size", ouvrages.size());
                
                //Forward to the jsp page for rendering
                request.getRequestDispatcher("browseCatalog.jsp").forward(request, response);
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

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
