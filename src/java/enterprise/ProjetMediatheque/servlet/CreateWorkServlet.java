package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Ouvrage;
import enterprise.ProjetMediatheque.entity.Auteur;
import enterprise.ProjetMediatheque.entity.Genre;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            
            List auteurs = em.createQuery("select a from Auteur a").getResultList();
            request.setAttribute("auteursList",auteurs);
            
            List genres= em.createQuery("select g from Genre g").getResultList();
            request.setAttribute("genresList",genres);
            
            request.getRequestDispatcher("createWork.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if(em != null) {
                em.close();
            }
        }
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            String titre  = (String) request.getParameter("titre");
           
            Date datePremierePublication = null;
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                datePremierePublication = formatter.parse(request.getParameter("datePremierePublication"));
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            
            em = emf.createEntityManager();
            
            String[] auteursIDs = request.getParameterValues("auteurs");
            List<Auteur> auteurs = new ArrayList<Auteur>();
            for(int i=0; i < auteursIDs.length; i++)
                auteurs.add(em.find(Auteur.class, Long.parseLong(auteursIDs[i])));
            
            String[] nomsGenres = request.getParameterValues("genres");
            List<Genre> genres = new ArrayList<Genre>();
            for(int i=0; i < nomsGenres.length; i++)
                genres.add(em.find(Genre.class, nomsGenres[i]));
            
            em.close();
            
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
            response.sendRedirect("ListWorks");
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if(em != null) {
                em.close();
            }
        }
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
}
