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
            String req_prenom           = (String) request.getParameter("prenom");
            String req_nom              = (String) request.getParameter("nom");
            String req_dateNaissance    = (String) request.getParameter("dateNaissance");
            String req_motDePasse       = (String) request.getParameter("motDePasse");
            String req_motDePasseBis    = (String) request.getParameter("motDePasseBis");
            String req_rueAdresse       = (String) request.getParameter("rueAdresse");
            String req_ville            = (String) request.getParameter("ville");
            String req_codePostal       = (String) request.getParameter("codePostal");
            
            // Demarrage de la transaction
            utx.begin();
            
            //Creation d'un Entity Manager
            //Since the em is created inside a transaction, it is associsated with the transaction
            em = emf.createEntityManager();
            
            Ville ville;
            // appelle la namedQuery "Ville.get"
            TypedQuery<Ville> getVille = em.createNamedQuery("Ville.get", Ville.class);
            // definit une valeur aux parametres
            getVille.setParameter("codePostal", Integer.parseInt(req_codePostal));
            getVille.setParameter("nomVille", req_ville);
            try{
                ville = getVille.getSingleResult();
                // si la ville n'existe pas deja dans la bdd
            }catch(NoResultException e){
                ville = new Ville(Integer.parseInt(req_codePostal), req_ville);
            }
            
            Adresse adresse = null;
            // appelle la namedQuery "Adresse.get"
            TypedQuery<Adresse> getAdresse = em.createNamedQuery("Adresse.get", Adresse.class);
            // definit une valeur aux parametre
            getAdresse.setParameter("rue", req_rueAdresse);
            getAdresse.setParameter("ville", ville);
            try{
                adresse = getAdresse.getSingleResult();
            }catch(NoResultException e){
                // si l'adresse n'existe pas deja dans la bdd
                adresse = new Adresse(req_rueAdresse, ville);
            }
            
            Date aujourdhui = new Date();
            
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // TODO : check la date de naissance
            Date dateNaissance = simpleDateFormat.parse(req_dateNaissance);
                        
            // Creation de l'adherent
            //Adherent newAdherent = new Adherent(req_nom, req_prenom, aujourdhui, aujourdhui, 0, adresse);
            Adherent adherent = null;
            // appelle la namedQuery "Adherent.get"
            TypedQuery<Adherent> getAdherent = em.createNamedQuery("Adherent.get", Adherent.class);
            // definit une valeur aux parametre
            getAdherent.setParameter("nom", req_nom);
            getAdherent.setParameter("prenom", req_prenom);
            getAdherent.setParameter("dateNaissance", dateNaissance);
            try{
                adherent = getAdherent.getSingleResult();
                request.setAttribute("alert", "<span class=\"alert\">L'ad&eacute;rent " + req_prenom + " " + req_nom + " existe d&eacute;j&agrave;</span>");
                request.getRequestDispatcher("createMember.jsp").forward(request, response);
            }catch(NoResultException e){
                // si l'adherent n'existe pas deja dans la bdd
                adherent = new Adherent(req_nom, req_prenom, dateNaissance, aujourdhui, 0, adresse);
            }
            
            
            
            if(req_motDePasse.equals(req_motDePasseBis)){
                adherent.setMotDePasse(req_motDePasse);
            }else{
                request.setAttribute("alert", "<span class=\"alert\">Les 2 mots de passe sont diff&eacute;rent !</span>");
                request.getRequestDispatcher("createMember.jsp").forward(request, response);
            }
            
            
            
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
            if(em != null) {
                em.close();
            }
        }
        
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
