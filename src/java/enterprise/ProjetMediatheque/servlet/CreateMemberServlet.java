/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Adherent;
import enterprise.ProjetMediatheque.entity.Adresse;
import enterprise.ProjetMediatheque.entity.Ville;
import java.io.IOException;
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
 * @author Gilles
 */
@WebServlet(name = "CreateMember", urlPatterns = {"/CreateMember"})
public class CreateMemberServlet extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    private String req_prenom = "";
    private String req_nom = "";
    private String req_dateNaissance = "";
    private String req_motDePasse = "";
    private String req_motDePasseBis = "";
    private String req_rueAdresse = "";
    private String req_ville = "";
    private String req_codePostal = "";

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
            req_prenom = (String) request.getParameter("prenom");
            req_nom = (String) request.getParameter("nom");
            req_dateNaissance = (String) request.getParameter("dateNaissance");
            req_motDePasse = (String) request.getParameter("motDePasse");
            req_motDePasseBis = (String) request.getParameter("motDePasseBis");
            req_rueAdresse = (String) request.getParameter("rueAdresse");
            req_ville = (String) request.getParameter("ville");
            req_codePostal = (String) request.getParameter("codePostal");

            // <editor-fold defaultstate="collapsed" desc="Check que les donnees ne sont pas vide">
            if (req_prenom.isEmpty()) {
                returnMessageError(request, response, "Veuillez entrer un pr&eacutenom !");
            } else if (req_nom.isEmpty()) {
                returnMessageError(request, response, "Veuillez entrer un nom !");
            } else if (req_dateNaissance.isEmpty()) {
                returnMessageError(request, response, "Veuillez entrer une date de naissance !");
            } else if (req_motDePasse.isEmpty()) {
                returnMessageError(request, response, "Veuillez entrer un mot de passe !");
            } else if (req_motDePasseBis.isEmpty()) {
                returnMessageError(request, response, "Veuillez entrer un second mot de passe, identique au premier !");
            } else if (req_rueAdresse.isEmpty()) {
                returnMessageError(request, response, "Veuillez entrer une adresse !");
            } else if (req_ville.isEmpty()) {
                returnMessageError(request, response, "Veuillez entrer une ville !");
            } else if (req_codePostal.isEmpty()) {
                returnMessageError(request, response, "Veuillez entrer un code postal !");
            }
            if (!req_motDePasse.equals(req_motDePasseBis)) {
                returnMessageError(request, response, "Les 2 mots de passe doivent &ecirc;tre identiques!");
            }
            // </editor-fold>

            // Demarrage de la transaction
            utx.begin();

            //Creation d'un Entity Manager
            //Since the em is created inside a transaction, it is associsated with the transaction
            em = emf.createEntityManager();

            // <editor-fold defaultstate="collapsed" desc="Initialisation de la Ville">
            Ville ville;
            // appelle la namedQuery "Ville.get"
            TypedQuery<Ville> getVille = em.createNamedQuery("Ville.get", Ville.class);
            // definit une valeur aux parametres
            getVille.setParameter("codePostal", Integer.parseInt(req_codePostal));
            getVille.setParameter("nomVille", req_ville);
            try {
                ville = getVille.getSingleResult();
                // si la ville n'existe pas deja dans la bdd
            } catch (NoResultException e) {
                ville = new Ville(Integer.parseInt(req_codePostal), req_ville);
            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc="Initialisation de l'Adresse">
            Adresse adresse = null;
            // appelle la namedQuery "Adresse.get"
            TypedQuery<Adresse> getAdresse = em.createNamedQuery("Adresse.get", Adresse.class);
            // definit une valeur aux parametre
            getAdresse.setParameter("rue", req_rueAdresse);
            getAdresse.setParameter("ville", ville);
            try {
                adresse = getAdresse.getSingleResult();
            } catch (NoResultException e) {
                // si l'adresse n'existe pas deja dans la bdd
                adresse = new Adresse(req_rueAdresse, ville);
            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc="Initialisation de la Date">
            Date aujourdhui = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateNaissance = simpleDateFormat.parse(req_dateNaissance);
            // </editor-fold>

            // TODO : aller cherche le solde en fction de son age et de sa ville
            int solde = 0;

            // <editor-fold defaultstate="collapsed" desc="Initialisation de l'Adherent">
            //Adherent newAdherent = new Adherent(req_nom, req_prenom, aujourdhui, aujourdhui, 0, adresse);
            Adherent adherent = null;
            // appelle la namedQuery "Adherent.get"
            TypedQuery<Adherent> getAdherent = em.createNamedQuery("Adherent.get", Adherent.class);
            // definit une valeur aux parametre
            getAdherent.setParameter("nom", req_nom);
            getAdherent.setParameter("prenom", req_prenom);
            getAdherent.setParameter("dateNaissance", dateNaissance);
            try {
                adherent = getAdherent.getSingleResult();
                request.setAttribute("alert", "<span class=\"alert\">L'ad&eacute;rent " + req_prenom + " " + req_nom + " existe d&eacute;j&agrave;</span>");
                request.getRequestDispatcher("createMember.jsp").forward(request, response);
            } catch (NoResultException e) {
                // si l'adherent n'existe pas deja dans la bdd
                adherent = new Adherent(req_nom, req_prenom, dateNaissance, aujourdhui, solde, adresse);
            }
            // </editor-fold>


            adherent.setMotDePasse(req_motDePasse);


            // persist the person entity
            em.persist(adherent);

            //commit transaction which will trigger the em to 
            //commit newly created entity into database
            utx.commit();

            //Forward to ListPerson servlet to list persons along with the newly
            //created person above
            request.setAttribute("nom", req_nom);
            request.setAttribute("prenom", req_prenom);
            request.getRequestDispatcher("confirmationCreateMember.jsp").forward(request, response);

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
     * Retourne une message d'erreur a la page createMember.jsp
     * @param request
     * @param response
     * @param msg
     */
    private void returnMessageError(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
        request.setAttribute("alert",           "<span class=\"alert\">" + msg + "</span>");
        request.setAttribute("prenom",          req_prenom);
        request.setAttribute("nom",             req_nom);
        request.setAttribute("dateNaissance",   req_dateNaissance);
        request.setAttribute("rue",             req_rueAdresse);
        request.setAttribute("ville",           req_ville);
        request.setAttribute("codePostal",      req_codePostal);
        request.getRequestDispatcher("createMember.jsp").forward(request, response);
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
