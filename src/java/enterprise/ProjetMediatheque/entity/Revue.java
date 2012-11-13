package enterprise.ProjetMediatheque.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 *
 * @author sbai
 */
@Entity
@DiscriminatorValue("JOURNAL")
@Table(name = "JOURNAL")
public class Revue extends Ouvrage{

    @Column(name = "DOMAINE")
    private String domaine;
     
    /**
     * Creates a new instance of Revue
     */
    public Revue() {
    }

    public Revue(String domaine) {
        this.domaine = domaine;
    }
    
    public String getDomaine() {
        return this.domaine;
    }          
}

