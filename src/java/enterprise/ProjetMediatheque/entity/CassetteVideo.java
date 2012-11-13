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
@DiscriminatorValue("VIDEOTAPE")
@Table(name = "VIDEOTAPES")
public class CassetteVideo extends Ouvrage{

    @Column(name = "VIDEOTAPE_DURATION")
    private int dureeCassette;
      
    /**
     * Creates a new instance of CassetteVideo
     */
    public CassetteVideo() {
    }

    public CassetteVideo(Type type, 
            String titre, 
            Date datePremierePublication,
            List<Auteur> auteurs, 
            List<Genre> genres, 
            int dureeCassette) {
        super(type, titre, datePremierePublication, auteurs, genres);
        this.dureeCassette = dureeCassette; 
    }
 
    public int getDureeCassette() {
        return this.dureeCassette;
    }
    
    public String toString() {
        String s = super.toString();
        s += "Duree : " + this.dureeCassette;
        
        return s;
    }
}
