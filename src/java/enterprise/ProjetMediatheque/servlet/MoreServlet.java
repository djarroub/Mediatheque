/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Ouvrage;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "MoreServlet", urlPatterns = {"/More"})
public class MoreServlet extends HttpServlet {

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
            if (request.getParameter("idOuvrage") != null) {
                assert emf != null;  //Make sure injection went through correctly.
                EntityManager em = null;
                try {
                    em = emf.createEntityManager();

                    Ouvrage ouvrage = em.find(Ouvrage.class, Long.parseLong(request.getParameter("idOuvrage")));
                    request.setAttribute("ouvrage", ouvrage);

                    //Forward to the jsp page for rendering
                    request.getRequestDispatcher("more.jsp").forward(request, response);
                } catch (Exception ex) {
                    throw new ServletException(ex);
                } finally {
                    //close the em to release any resources held up by the persistence provider
                    if(em != null) {
                        em.close();
                    }
                }
            } else {
                response.sendRedirect("/ListWorks");
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
