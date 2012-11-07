package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Temporal;

/**
 *
 * @author sbai
 */
@Entity
@Table(name = "TYPE")
public class Type implements Serializable {

    @Id
    @Column(name = "NOM")
    private String nom;

    @Column(name = "DUREE_EMPRUNT_MAX")
    private String dureeEmpruntMax;
  
    @Column(name = "NB_EMPRUNT_MAX")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePremierePublication;
    
    
    /**
     * Creates a new instance of Ouvrage
     */
    public Type() {
    }

    public Type(String id, String titre, Date datePremierePublication) {
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
