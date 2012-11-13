package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Ouvrage;
import enterprise.ProjetMediatheque.entity.Adherent;
import enterprise.ProjetMediatheque.entity.Reservation;
import enterprise.ProjetMediatheque.entity.TypeName;
import java.io.*;
import javax.persistence.Query;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.annotation.Resource;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

/**
 *
 * @author sbai
 */
@WebServlet(name = "CreateReservationServlet", urlPatterns = {"/CreateReservation"})
public class CreateReservationServlet extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;  
    
    @Resource
    private UserTransaction utx;

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            
            List auteurs = em.createQuery("select o from Ouvrage o").getResultList();
            request.setAttribute("ouvragesList",auteurs);
            
            List genres= em.createQuery("select a from Adherent a").getResultList();
            request.setAttribute("adherentsList",genres);
            
            request.getRequestDispatcher("createReservation.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if(em != null) {
                em.close();
            }
        }
    }
    
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
           
            em = emf.createEntityManager();  
            utx.begin();
            em = emf.createEntityManager();
            //en premier on reccupère l'adherent 
                                
            String adh = request.getParameter("adherent");           
            System.out.println("ref client"+adh);
            Query req= (Query) em.createQuery("select a from Adherent a where a.idAdhesion = :ref");
            req.setParameter("ref", adh);
            Adherent adherent = (Adherent)req.getSingleResult();
            
            TypedQuery<Ouvrage> typeQuery = em.createNamedQuery("Ouvrage.Get", Ouvrage.class);
            typeQuery.setParameter("id", TypeName.valueOf((String)request.getParameter("ouvrage")));
            Ouvrage ouvrage = typeQuery.getSingleResult();
                        
            em.close();
            
            //Create an Ouvrage instance out of it
            Reservation reservation = new Reservation(adherent, ouvrage);
            
            //begin a transaction
            utx.begin();
            //create an em. 
            //Since the em is created inside a transaction, it is associsated with 
            //the transaction
            em = emf.createEntityManager();
            
            
                      //persist the person entity
            em.persist(reservation);
                     
            //commit transaction which will trigger the em to 
            //commit newly created entity into database
            utx.commit();
            
            //Forward to ListWorks servlet to list works along with the newly
            //created work above
            
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
