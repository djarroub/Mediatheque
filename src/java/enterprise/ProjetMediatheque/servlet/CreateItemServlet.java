/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Auteur;
import enterprise.ProjetMediatheque.entity.Item;
import enterprise.ProjetMediatheque.entity.Ouvrage;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Gilles
 */
@WebServlet(name = "CreateItemServlet", urlPatterns = {"/CreateItem"})
public class CreateItemServlet extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    private String req_ouvrage = "";
    private String req_nbExemplaire = "";

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            
            List ouvrages = em.createQuery("select a from Ouvrage a").getResultList();
            request.setAttribute("ouvrages", ouvrages);
            
            request.getRequestDispatcher("createItem.jsp").forward(request, response);
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            //begin a transaction
            utx.begin();
            //create an em. 
            //Since the em is created inside a transaction, it is associsated with 
            //the transaction
            em = emf.createEntityManager();
            
            //Get the data from user's form
            req_ouvrage = (String) request.getParameter("ouvrage");
            req_nbExemplaire = (String) request.getParameter("nbExemplaire");

            if (req_ouvrage.isEmpty()) {
                returnMessageError(request, response, "Veuillez s&eacute;lectionner un ouvrage!");
            } else if (req_nbExemplaire.isEmpty()) {
                returnMessageError(request, response, "Veuillez entrer un nombre d'exemplaire !");
            }


            Ouvrage ouvrage = null;
            ouvrage = em.find(Ouvrage.class, Long.parseLong(req_ouvrage));

            if (ouvrage == null) {
                returnMessageError(request, response, "Un probl&egrave;me est survenu avec l'importation de l'ouvrage !");
            }

            Item item = new Item(ouvrage);
            if (item == null) {
                returnMessageError(request, response, "Un probl&egrave;me est survenu avec la creation de l'item !");
            }
            
            
            //persist the person entity
            em.persist(item);
            //commit transaction which will trigger the em to 
            //commit newly created entity into database
            utx.commit();

            //Forward to ListPerson servlet to list persons along with the newly
            //created person above
            response.sendRedirect("CreateItem");
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    /**
     * Retourne une message d'erreur a la page createItem.jsp
     *
     * @param request
     * @param response
     * @param msg
     */
    private void returnMessageError(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
        request.setAttribute("alert", "<span class=\"alert\">" + msg + "</span>");
        request.getRequestDispatcher("createItem.jsp").forward(request, response);
    }
}
