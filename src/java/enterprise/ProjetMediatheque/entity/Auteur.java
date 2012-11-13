package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author sbai
 */
@Entity
@Table(name = "AUTHORS")
@SequenceGenerator(
        name = "AUTHOR_SEQUENCE",
        sequenceName = "AUTHOR_SEQUENCE",
        initialValue = 0,
        allocationSize = 1)
public class Auteur implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTHOR_SEQUENCE")
    @Column(name = "ID")
    private Long id;

    @Column(name = "LASTNAME")
    private String nom;
  
    @Column(name = "FIRSTNAME")
    private String prenom;
    
   @ManyToMany(cascade=CascadeType.ALL)
   @JoinTable(name = "WORK_AUTHOR",
        joinColumns = {
            @JoinColumn(name="AUTHOR_ID", referencedColumnName="ID") 
        },
        inverseJoinColumns = {
            @JoinColumn(name="WORK_ID", referencedColumnName="ID")
        }
   )
   private List<Ouvrage> ouvrages;
   
    /**
     * Creates a new instance of Ouvrage
     */
    public Auteur() {
    }

    public Auteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom=prenom;
       
    }

    public Long getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }
    
    public List<Ouvrage> getOuvrages() {
        return ouvrages;
   }
    
    public void addOuvrage(Ouvrage o) {
        this.ouvrages.add(o);
    }
}
