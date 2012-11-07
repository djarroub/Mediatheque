package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Gilles
 */
@Entity
@Table (name="ADRESS")
public class Adresse implements Serializable {
    @Id @GeneratedValue
    @Column (name="ID") // innutile car : nom de variable = nom de colomne
    private Long id;
    
    @Column(name="STREET")
    private String rue;
    
    @ManyToOne
    @JoinColumn(name="CITY_ID")
    private Ville ville;
    
    
    // ---------------------------------
    //   Constructeur
    // ---------------------------------
    /**
     * Constructeur vide de la classe Adresse.
     */
    public Adresse(){}

    /**
     * Constructeur de la classe Adresse.
     * @param id L'id de la classe Adresse dans la BDD.
     * @param rue La rue associee a l'adresse.
     * @param ville La ville associee a l'adresse.
     * @param codePostale Le code postal associe a cette Adresse.
     */
    public Adresse(Long id, String rue, Ville ville, int codePostale) {
        this.id = id;
        this.rue = rue;
        this.ville = ville;
    }
    
    
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

}
