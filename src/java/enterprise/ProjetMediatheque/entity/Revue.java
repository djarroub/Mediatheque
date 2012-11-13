package enterprise.ProjetMediatheque.entity;

import java.util.Date;
import java.util.List;
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
@Table(name = "JOURNALS")
public class Revue extends Ouvrage{

    @Column(name = "DOMAINE")
    private String domaine;
     
    /**
     * Creates a new instance of Revue
     */
    public Revue() {
    }

    public Revue(Type type, 
            String titre, 
            Date datePremierePublication,
            List<Auteur> auteurs, 
            List<Genre> genres, 
            String domaine) {
        super(type, titre, datePremierePublication, auteurs, genres);
        this.domaine = domaine;
    }
    
    public String getDomaine() {
        return this.domaine;
    }
    
    public String toString() {
        String s = super.toString();
        s += "Domaine : " + this.domaine;
        
        return s;
    }
}

