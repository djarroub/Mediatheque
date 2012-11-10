package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author sbai
 */
@Entity
@Table(name = "AUTEUR")
public class Auteur implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID_AUTEUR")
    private String id;

    @Column(name = "NOM")
    private String nom;
  
    @Column(name = "PRENOM")
    private String prenom;
    
   @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "AUTEUR_OUVRAGE",
    joinColumns = {
    @JoinColumn(name="ID_AUTEUR") 
    },
    inverseJoinColumns = {
    @JoinColumn(name="ID_OUVRAGE")
    }
    )
   private Set<Ouvrage> ouvrages;
   
    /**
     * Creates a new instance of Ouvrage
     */
    public Auteur() {
    }

    public Auteur(String id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom=prenom;
       
    }

    public String getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }
    public Set<Ouvrage> getOuvrages() {
        
       return ouvrages;
   }
}
