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
@DiscriminatorColumn(name="CASSETTE_VIDEO")
@Table(name = "CASSETTE_VIDEO")
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
