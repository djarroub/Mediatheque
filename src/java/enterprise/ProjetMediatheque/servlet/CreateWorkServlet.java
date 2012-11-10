package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Ouvrage;
import enterprise.ProjetMediatheque.entity.Auteur;
import enterprise.ProjetMediatheque.entity.Genre;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;


/**
 * The sevelet class to insert Ouvrage into database
 */
@WebServlet(name="CreateWorkServlet", urlPatterns={"/CreateWork"})
public class CreateWorkServlet extends HttpServlet {
    
    @PersistenceUnit
    //The emf corresponding to 
    private EntityManagerFactory emf;  
    
    @Resource
    private UserTransaction utx;

    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            String titre  = (String) request.getParameter("titre");
           
            Date datePremierePublication = new Date();
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
                datePremierePublication = formatter.parse(request.getParameter("datePremierePublication"));
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            
            
            em = emf.createEntityManager();

            Set<Auteur> auteurs = (Set<Auteur>) em.createQuery("select a.nom, a.prenom from Auteur a").getResultList();
            request.setAttribute("auteursList",auteurs);
            System.out.println(auteurs);
            
            
            
            Set<Genre> genres=(Set<Genre>) em.createQuery("select g.nom from Genre g").getResultList();
            request.setAttribute("genresList",genres);
            System.out.println(genres);
            
                              
            //Create an Ouvrage instance out of it
            Ouvrage ouvrage = new Ouvrage(titre, datePremierePublication, auteurs, genres);
            
            //begin a transaction
            utx.begin();
            //create an em. 
            //Since the em is created inside a transaction, it is associsated with 
            //the transaction
            em = emf.createEntityManager();
            //persist the person entity
            em.persist(ouvrage);
            //commit transaction which will trigger the em to 
            //commit newly created entity into database
            utx.commit();
            
            //Forward to ListWorks servlet to list works along with the newly
            //created work above
            request.getRequestDispatcher("/ListWorks").forward(request, response);
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
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
