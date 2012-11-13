/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Auteur;
import enterprise.ProjetMediatheque.entity.Genre;
import enterprise.ProjetMediatheque.entity.Magazine;
import enterprise.ProjetMediatheque.entity.Type;
import enterprise.ProjetMediatheque.entity.TypeName;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "CreateMagazineServlet", urlPatterns = {"/CreateMagazine"})
public class CreateMagazineServlet extends HttpServlet {

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
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            
            List auteurs = em.createQuery("select a from Auteur a").getResultList();
            request.setAttribute("auteursList",auteurs);
            
            List genres= em.createQuery("select g from Genre g").getResultList();
            request.setAttribute("genresList",genres);
            
            request.getRequestDispatcher("createMagazine.jsp").forward(request, response);
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
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
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
            
            Type type = em.find(Type.class, TypeName.MAGAZINE);
            
            int numero = Integer.parseInt(request.getParameter("numero"));
            
            em.close();
            
            //Create an Ouvrage instance out of it
            Magazine ouvrage = new Magazine(type, titre, datePremierePublication, auteurs, genres, numero);
            
            //begin a transaction
            utx.begin();
            //create an em. 
            //Since the em is created inside a transaction, it is associsated with 
            //the transaction
            em = emf.createEntityManager();
            
            for (Auteur a : auteurs) {
                a.addOuvrage(ouvrage);
            }
            
            for (Genre g : genres) {
                g.addOuvrage(ouvrage);
            }
            
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
}
