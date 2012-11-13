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
@DiscriminatorValue("VIDEOTAPE")
@Table(name = "VIDEOTAPES")
public class CassetteVideo extends Ouvrage{

    @Column(name = "VIDEOTAPE_DURATION")
    private String dureeCassette;
      
    /**
     * Creates a new instance of CassetteVideo
     */
    public CassetteVideo() {
    }

    public CassetteVideo(String dureeCassette) {
        this.dureeCassette = dureeCassette; 
    }
 
    public String getDureeCassette() {
        return this.dureeCassette;
    }
      
}
