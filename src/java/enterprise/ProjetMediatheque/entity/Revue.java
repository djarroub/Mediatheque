package enterprise.ProjetMediatheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author sbai
 */
@Entity
@Table(name = "REVUE")
public class Revue extends Ouvrage{

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "DOMAINE")
    private String domaine;
  
   
    /**
     * Creates a new instance of Revue
     */
    public Revue() {
    }

    public Revue(int id, String domaine) {
        this.id = id;
        this.domaine = domaine;
       
    }

    
    public String getDomaine() {
        return this.domaine;
    }
      
    
}

