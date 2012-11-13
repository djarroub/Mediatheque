/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Adherent;
import enterprise.ProjetMediatheque.entity.Adresse;
import enterprise.ProjetMediatheque.entity.Emprunt;
import enterprise.ProjetMediatheque.entity.Item;
import enterprise.ProjetMediatheque.entity.Ville;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
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
@WebServlet(name = "BorrowItemServlet", urlPatterns = {"/BorrowItem"})
public class BorrowItemServlet extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    String req_idItem = "";
    String req_idAdherent = "";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        assert emf != null;
        EntityManager em = null;

        try {
            //Get the data from user's form
            req_idItem = (String) request.getParameter("idItem");
            req_idAdherent = (String) request.getParameter("idAdherent");

            // <editor-fold defaultstate="collapsed" desc="Check que les donnees ne sont pas vide">
            if (req_idItem.isEmpty()) {
                returnMessageError(request, response, "Veuillez entrer un pr&eacutenom !");
            } else if (req_idAdherent.isEmpty()) {
                returnMessageError(request, response, "Veuillez entrer un nom !");
            }
            // </editor-fold>

            // Demarrage de la transaction
            utx.begin();

            //Creation d'un Entity Manager
            //Since the em is created inside a transaction, it is associsated with the transaction
            em = emf.createEntityManager();

            // <editor-fold defaultstate="collapsed" desc="Initialisation de l'Emprunt">
            // nous servira pour les parametres de l'emprunt
            Adherent adherent = (Adherent) em.find(Adherent.class, Long.parseLong(req_idAdherent));
            Item item = (Item) em.find(Item.class, Long.parseLong(req_idItem));
            
            Emprunt emprunt = new Emprunt(adherent, item);
            // </editor-fold>

            // persist the person entity
            em.persist(emprunt);

            //commit transaction which will trigger the em to 
            //commit newly created entity into database
            utx.commit();

            //Forward to ListPerson servlet to list persons along with the newly
            //created person above
            request.setAttribute("confirmationCreationMembre", "<div class=\"info\">L'adh&eacute;rent " + adherent.getPrenom() + " " + adherent.getNom() + " (id: " + adherent.getNumCarte() + ") a bien emprunt&eacute; l'item " + item.getOuvrage().getTitre() + " (id: " + item.getId() + ").</div>");
            request.getRequestDispatcher("createMember.jsp").forward(request, response);

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
     * Retourne une message d'erreur a la page borrowItem.jsp
     *
     * @param request
     * @param response
     * @param msg
     */
    private void returnMessageError(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
        request.setAttribute("alert", "<span class=\"alert\">" + msg + "</span>");
        request.setAttribute("idItem", req_idItem);
        request.setAttribute("idAdherent", req_idAdherent);
        request.getRequestDispatcher("borrowItem.jsp").forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
