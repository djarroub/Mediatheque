package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
        
    
    @ManyToOne
    @JoinColumn(name="ID")
    private Ouvrage ouvrage;
    
    /**
     * Creates a new instance of Item
     */
    public Item() {
    }

    public Item(String id, String statut, Ouvrage ouvrage) {
        this.id = id;
        this.statut = statut;
        this.ouvrage=ouvrage;
        
    }

    public String getId() {
        return this.id;
    }

    public String getStatut() {
        return this.statut;
    }
    
    public Ouvrage GetOuvrage(){
        return this.ouvrage;
}
   
}
