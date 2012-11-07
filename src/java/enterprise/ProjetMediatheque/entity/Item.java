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
@Table(name = "ITEM")
public class Item implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "STATUT")
    private String statut;
  
   
    
    /**
     * Creates a new instance of Item
     */
    public Item() {
    }

    public Item(String id, String statut) {
        this.id = id;
        this.statut = statut;
        
    }

    public String getId() {
        return this.id;
    }

    public String getStatut() {
        return this.statut;
    }

   
}
