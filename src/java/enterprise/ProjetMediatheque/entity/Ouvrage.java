package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;

/**
 *
 * @author sbai
 */
@Entity
@Table(name = "OUVRAGE")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Ouvrage implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "TITRE")
    private String titre;
  
    @Column(name = "DATE_PREMIERE_PUBLICATION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePremierePublication;
    
    
    /**
     * Creates a new instance of Ouvrage
     */
    public Ouvrage() {
    }

    public Ouvrage(String id, String titre, Date datePremierePublication) {
        this.id = id;
        this.titre = titre;
        this.datePremierePublication=datePremierePublication;
        
    }

    public String getId() {
        return this.id;
    }

    public String getTitre() {
        return this.titre;
    }

    public Date getDatePremierePublication(){
        return this.datePremierePublication;
    }
    
}
