package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gilles
 */
@Entity
@Table (name="ADRESS")
public class Adresse implements Serializable {
    @Id @Column (name="ID")
    private Long id;
    
    @Column(name="STREET")
    private String rue;
    
    @OneToOne
    @JoinColumn(name="CITY")
    private Ville ville;
    
    // TODO : verifier que c'est bien "OneToMany"
    @OneToMany
    @JoinColumn(name="MEMBER_ID")
    private List<Adherent> listeAdherent;  // TODO : verifier si c'est 1 Adherent ou une collection d'adherent que l'on recupere!!
    
    // ---------------------------------
    //   Accesseur
    // ---------------------------------
    // TODO : Ecrire un descriptif pour la JavaDoc
    /**
     * 
     * @return L'id de l'objet Adresse.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * 
     * @return La rue associee a l'Adresse.
     */
    public String getRue(){
        return rue;
    }
    
    /**
     * 
     * @return La ville associee a l'Adresse.
     */
    public Ville getVille(){
        return ville;
    }
    
    /**
     * 
     * @return La liste d'Adherent qui ont cette Adresse.
     */
    public List<Adherent> getListeAdherent(){
        return listeAdherent;
    }
    // ---------------------------------
    //   Modificateur
    // ---------------------------------
    /**
     * 
     * @param id Le nouvel id d'Adresse.
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * 
     * @param rue La nouvelle rue associee a Adresse.
     */
    public void setRue(String rue){
        this.rue = rue;
    }
    
    /**
     * 
     * @param ville La nouvelle ville associee a Adresse.
     */
    public void setVille(Ville ville){
        this.ville = ville;
    }
    
    /**
     * 
     * @param listeAdherent La nouvelle liste d'Adherent qui ont cette Adresse.
     */
    public void setListeAdherent(List<Adherent> listeAdherent){
        this.listeAdherent = listeAdherent;
    }
    
}
