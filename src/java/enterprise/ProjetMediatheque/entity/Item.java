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
    private Long id;

    @Column(name = "STATUS")
    private String statut;        
    
    @ManyToOne
    @JoinColumn(name="WORK_ID")
    private Ouvrage ouvrage;
    
    /**
     * Creates a new instance of Item
     */
    public Item() {
    }

    public Item(String statut, Ouvrage ouvrage) {
        this.statut = statut;
        this.ouvrage=ouvrage;
        
    }

    public Long getId() {
        return this.id;
    }

    public String getStatut() {
        return this.statut;
    }
    
    public Ouvrage getOuvrage(){
        return this.ouvrage;
}
   
}
