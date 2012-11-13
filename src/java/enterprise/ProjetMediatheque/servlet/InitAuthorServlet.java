/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.servlet;

import enterprise.ProjetMediatheque.entity.Auteur;
import enterprise.ProjetMediatheque.entity.Type;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
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
@WebServlet(name = "InitAuthorServlet", urlPatterns = {"/InitAuthor"})
public class InitAuthorServlet extends HttpServlet {

    @PersistenceUnit
    EntityManagerFactory emf;
    
    @Resource
    private UserTransaction utx;
    
    private int nbAuthor = 50;

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
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            utx.begin();
            em = emf.createEntityManager();
            Query query = em.createQuery("delete from Auteur a");
            query.executeUpdate();
            for (int i = 0; i < nbAuthor; i++) {
                em.persist(new Auteur(getRandomNom(), getRandomNom()));
            }
            utx.commit();
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if (em != null) {
                em.close();
                response.sendRedirect("ListAuthors");
            }
        }
    }

    private String getRandomNom() {
        String[] tabNom = {"Yaacov", "Yacin", "Yacine", "Yacouba", "Yaël", "Yahia", "Yahya", "Yamin", "Yamine", "Yan", "Yani", "Yanice", "Yanick", "Yanik", "Yanis", "Yaniss", "Yanisse", "Yaniv", "Yann", "Yanne", "Yanni", "Yannic", "Yannice", "Yannick", "Yannig", "Yannik", "Yannis", "Yao", "Yasin", "Yasine", "Yasmin", "Yasser", "Yassin", "Yassine", "Yassir", "Yasuo", "Yazid", "Ydriss", "Yehiel", "Yéhouda", "Yekel", "Yen", "Yeram", "Yeraz", "Ylan", "Ylann", "Ylies", "Yliess", "Yoan", "", "", "Yoann", "Yoanne", "Yoav", "Yoël", "Yohan", "Yohann", "Yohanne", "Yolan", "Yoland", "Yon", "Yona", "Yonathan", "Yoni", "Yonni", "Yoram", "Yoran", "Yorick", "Yossef", "Youcef", "Youen", "Youenn", "Younès", "Youness", "Younesse", "Younous", "Youri", "Yousef", "Yousri", "Youssef", "Youssouf", "Yovan", "Yuli", "Yuma", "Yun", "Yunus", "Yunus-Emre", "Yuri", "Yury", "Yusuf", "Yvain", "Yvan", "Yvann", "Yvelin", "Yven", "Yves", "Yves-Marie", "Yvon", "Yvonick", "Yvonnic", "Yvonnick", "Aadil", "Aaron", "Aba", "Abarran", "Abbes", "Abdallah", "Abdel", "Abd-el", "Abdelali", "Abdelazim", "Abdèlaziz", "Abdelbari", "Abdelghani", "Abdèlhadi", "Abdelhafid", "Abdel-Hakim", "Abdelhalim", "Abdelhamid", "Abdelilah", "Abdeljalil", "Abdelkader", "Abdel-Kader", "Abdelkarim", "Abdel-Karim", "Abdelkrim", "Abdellah", "Abdelmajid", "Abdelmalek", "Abdelmalik", "Abdelnasser", "Abdelrahim", "Abdelrahmane", "Abdelrani", "Abdelsamad", "Abdelwahab", "Abdelwahhab", "Abdenour", "Abderahim", "Abderahmane", "Abderrahim", "Abderrahman", "Abderrahmane", "Abdeslam", "Abdessamad", "Abdou", "Abdoul", "Abdul", "Abdullah", "Abe", "Abed", "Abel", "", "Abélard", "Abelardo", "Abelin", "Abert", "Abgar", "Abib", "Abiel", "Abilio", "Abiona", "Abondance", "Abonde", "Aboubacar", "Aboubakar", "Abraham", "Abriel", "Absalon", "Acacio", "Achille", "Achilles", "Achim", "Achod", "Achraf", "Adaïa", "Adalard", "Adalbert", "Adam", "Adama", "Adame", "Adamo", "Adams", "Adan", "Addison", "Adei", "Adel", "Adelan", "Adélard", "Adelardo", "Adelbert", "Adelin", "Adelino", "Adelmard", "Adelphe", "Adem", "Adémar", "Adhémar", "Adiël", "Adil", "Adile", "Adiran", "Adler", "Adnan", "Dabi", "Daegan", "Daël", "Daelen", "Daelin", "Dagan", "Daï", "Dale", "Daley", "Dalian", "Dalil", "Dalmar", "Damase", "Damen", "Damian", "Damiano", "Damias", "Damien", "Damon", "Dan", "Dane", "Danel", "Dang", "Dani", "Danias", "Danic", "Danick", "Daniel", "Danik", "Danilo", "Dannick", "Danny", "Dante", "Danton", "Dany", "Daoud", "Daouda", "Dara", "Darcie", "Darcy", "Daren", "Dari", "Darin", "Dario", "Darius", "Daron", "Darrel", "Darren", "Darryl", "Daryl", "Datev", "", "Dauphin", "Dave", "Davi", "David", "Davide", "Davie", "Davis", "Davit", "Davon", "Davut", "Davy", "Dawi", "Dawid", "Dawson", "Dawud", "Daylan", "Dayle", "Dean", "Debus", "Dedié", "Delane", "Delfin", "Delmar", "Delphin", "Delys", "Demetre", "Demetrio", "Demetrios", "Demetrius", "Denez", "Deniel", "Denis", "Deniz", "Dennis", "Denny", "Dennys", "Denovan", "Denys", "Derek", "Déric", "Derick", "Derik", "Derric", "Derrick", "Derry", "Dertad", "Desidario", "Desiderius", "Désiré", "Desmond", "Deve", "Ladewig", "Ladislas", "Ladislav", "Ladix", "Laël", "Laelien", "Lahbib", "Laïd", "Lalo", "Lamar", "Lambert", "Lambrecht", "Lance", "Lancelot", "Lander", "Landry", "Laorans", "Larbi", "Larry", "Lars", "Lary", "Laslo", "Laszlo", "Latif", "Lauers", "Laureano", "Lauréat", "Laurel", "Laurent", "Laurentch", "Laurentian", "Laurentin", "Laurentino", "Laurentz", "Laurenz", "Laurenzo", "Laurenzu", "Lauri", "Laurian", "Lauric", "Laurick", "Lauridas", "Laurier", "Laurin", "Lauris", "Lauritz", "Lavr", "Lavrendios", "Lavrenti", "Lawrence", "Lazar", "", "Lazare", "Lazaro", "Lazarus", "Léandre", "Leandro", "Leandros", "Lee", "Leeroy", "Léger", "Lehen", "Lélio", "Lemuel", "Lenaïc", "Lenaïck", "Leni", "Lenny", "Leno", "Lénor", "Leny", "Léo", "Léocade", "Léocadia", "Léocadie", "Léon", "Leonaldo", "Leonar", "Léonar", "Léonard", "Leonardis", "Léonardo", "Léonce", "Leoncio", "Léonel", "Leonid", "Leonidas", "Leonide", "Léonor", "Léontin", "Léo-Paul", "Léopold", "Leopoldino", "Leopoldo", "Leroy", "Leslie", "Lévi", "Lévon", "Levy", "Lewis", "Li", "Liam", "Liberté", "Kaat", "Kabibi", "Kacey", "Kacia", "Kacie", "Kacy", "Kadia", "Kadidia", "Kadidja", "Kadija", "Kady", "Kaëla", "Kahéna", "Kahina", "Kahla", "Kai", "Kaï", "Kaïa", "Kaiko", "Kaïla", "Kaimana", "Kaïna", "Kaira", "Kaitlin", "Kaki", "Kala", "Kaléa", "Kalena", "Kaley", "Kali", "Kalie", "Kalila", "Kalina", "Kalinda", "Kaline", "Kalyne", "Kama", "Kamar", "Kamara", "Kamaria", "Kameko", "Kamela", "Kamelia", "Kamila", "Kamili", "Kamilia", "Kamilla", "Kamra", "Kana", "Kanani", "Kane", "", "Kani", "Kanna", "Kanoa", "Kany", "Kanza", "Kaoru", "Kaoura", "Kara", "Karama", "Kareen", "Karel", "Karell", "Karelle", "Karen", "Karène", "Karia", "Kariana", "Kariane", "Karianna", "Karianne", "Karima", "Karin", "Karina", "Karine", "Kariné", "Karitate", "Karla", "Karlèna", "Karlène", "Karlina", "Karline", "Karlota", "Karlotta", "Karmele", "Karmen", "Karola", "Karolane", "Karolanne", "Karolina", "Karoune", "Karyl", "Kasandra", "Kashmir", "Kasia", "Kassandra", "Kassandre", "Katalin", "Katalina", "Katalinta", "Katalinto", "Katarin", "Maaike", "Mabel", "Mabelia", "Mabella", "Mabelle", "Macha", "Madalen", "Madalena", "Madaleno", "Maddie", "Maddy", "Madelaine", "Madeleine", "Madelia", "Madelina", "Madeline", "Madelyn", "Madelyne", "Maden", "Madenn", "Madennig", "Madez", "Madge", "Madiana", "Madiha", "Madilyn", "Madin", "Madina", "Madison", "Madisone", "Madisson", "Madissone", "Madlie", "Madline", "Madly", "Mado", "Madonna", "Mady", "Madyson", "Madysson", "Mae", "Maé", "Maei", "Maeko", "Maël", "Maëla", "Maëlane", "Maële", "Maëlenn", "Maëlia", "Maëlice	 Maëlie", "Maëlig", "Maëline", "Maëlis", "Maëliss", "Maëlisse", "Maëlla", "Maëlle", "Maëllis", "Maëlly", "Maëllys", "Maëlwenn", "Maëly", "Maëlyne", "Maëlys", "Maëlyss", "Maena", "Maeva", "Maevane", "Maève", "Maewenn", "Mafalda", "Magali", "Magalie", "Magaly", "Magda", "Magdalaine", "Magdalen", "Magdalena", "Magdalène", "Magdalina", "Magdaline", "Magella", "Maggie", "Maggy", "Magnolia", "Maguelone", "Maguelonne", "Magui", "Maguy", "Maha", "Mahalia", "Mahats", "Mahaud", "Mahault", "Mahaut", "Mahé", "Maheva", "Mahina", "Mai", "Maï", "Ianna", "Ibai", "Ibaia", "Ida", "Idaline", "Ide", "Idra", "Ielena", "Ielene", "Iella", "Ignatia", "Igoa", "Igora", "Ihsane", "Ikram", "Ikrame", "Ilana", "Ilanit", "Ilda", "Ildegarde", "Ileana", "Ilena", "Ilenia", "Ilham", "Ilhame", "Ilhem", "Ilheme", "Ilia", "Iliana", "Iliane", "Iliona", "Ilione", "Ilka", "Ilki", "Illana", "Illena", "Illenia", "Illoa", "Illona", "Iloa", "Ilona", "Ilse", "Ilyana", "Ilyane", "Imae", "Imako", "Iman", "Imane", "Imelda", "Imen", "Imene", "", "Imma", "Ina", "Inas", "Inass", "Inasse", "Inaya", "India", "Indiana", "Indigo", "Indira", "Indra", "Iné", "Ines", "Inès", "Iness", "Inesse", "Inge", "Ingrid", "Innes", "Insaf", "Inssaf", "Intissar", "Ioanna", "Ioena", "Iola", "Iolanda", "Iolande", "Iole", "Iona", "Ione", "Ionia", "Ionna", "Iora", "Ioulando", "Iphigénie", "Iréa", "Iréna", "Irenca", "Irène", "Irénéa", "Irénée", "Irès", "Iriena", "Irina", "Iris", "Irma", "Irmeline", "Irmine", "Irvine", "Irvinia", "Isa"};
        Random r = new Random();
        int v = r.nextInt(tabNom.length);
        return tabNom[v];
    }

    private String getRandomPrenom() {
        String[] tabPrenom = {"Gilles"};
        Random r = new Random();
        int v = r.nextInt(tabPrenom.length);
        return tabPrenom[v];
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
