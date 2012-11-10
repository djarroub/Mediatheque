/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Adherent;
import enterprise.ProjetMediatheque.entity.Adresse;
import enterprise.ProjetMediatheque.entity.Ville;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
            
            Ville ville = new Ville(Integer.parseInt(req_codePostal), req_ville);
            Adresse adresse = new Adresse(req_rueAdresse, ville);
            
            Date aujourdhui = new Date();
            /*
            String _nom,
            String _prenom,
            Date _dateNaissance,
            Date _dateFinCotisation,
            int _soldeCompte,
            Adresse _adresse
            */
            
            //Create a person instance out of it
            Adherent newAdherent = new Adherent(req_nom, req_prenom, aujourdhui, aujourdhui, 0, adresse);
            //Person person = new Person(id, firstName, lastName);
            
            //begin a transaction
            utx.begin();
            //create an em. 
            //Since the em is created inside a transaction, it is associsated with 
            //the transaction
            em = emf.createEntityManager();
            //persist the person entity
            em.persist(newAdherent);
            //commit transaction which will trigger the em to 
            //commit newly created entity into database
            utx.commit();
            
            //Forward to ListPerson servlet to list persons along with the newly
            //created person above
            request.getRequestDispatcher("ListPerson").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if(em != null) {
                em.close();
            }
        }
        
        // <editor-fold defaultstate="collapsed" desc="vieux code">
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
           /*out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateMember</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateMember at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }*/
        // </editor-fold>
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
