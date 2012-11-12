package enterprise.ProjetMediatheque.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 *
 * @author sbai
 */
@Entity
@DiscriminatorColumn(name="JOURNAL")
@Table(name = "JOURNAL")
public class Revue extends Ouvrage{

    @Column(name = "DOMAIN")
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

