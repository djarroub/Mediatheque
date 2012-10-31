package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author sbai
 */
@Entity
@Table(name = "AUTEUR")
public class Auteur implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;
  
   @Column(name = "PRENOM")
    private String prenom;
    
    /**
     * Creates a new instance of Ouvrage
     */
    public Auteur() {
    }

    public Auteur(String id, String name, String prenom) {
        this.id = id;
        this.name = name;
        this.prenom=prenom;
        
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

   public String getPrenom(){
   
        return this.prenom;
   }
    
}
