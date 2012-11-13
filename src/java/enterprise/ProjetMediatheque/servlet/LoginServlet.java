/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Adherent;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    
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
        Long cardNumber = Long.valueOf(request.getParameter("cardNumber"));
        String password = request.getParameter("password");
        
        if (cardNumber != null && password != null) {
            assert emf != null;  //Make sure injection went through correctly.
            EntityManager em = null;
            try {
                em = emf.createEntityManager();
                
                TypedQuery<Adherent> query = em.createNamedQuery("Adherent.getByNumCarte", Adherent.class);
                query.setParameter("numCarte", cardNumber);
                Adherent adherent = query.getSingleResult();
                
                if (adherent.isRightPassword(password)) {
                    HttpSession session = request.getSession(true);
                    
                    session.setAttribute("adherent", adherent);
                    response.sendRedirect("BrowseCatalog");
                } else {
                    request.setAttribute("title", "lors de la connexion");
                    request.setAttribute("message", "Le numéro de carte ou le mot de passe "
                        + "que vous avez entré n'est pas bon.");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                throw new ServletException(ex);
            } finally {
                //close the em to release any resources held up by the persistence provider
                if(em != null) {
                    em.close();
                }
            }
        } else {
            request.setAttribute("title", "lors de la connexion");
            request.setAttribute("message", "Veuillez remplir tous les champs.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet responsable de la connexion d'un adhérent";
    }// </editor-fold>
}
