package enterprise.ProjetMediatheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author sbai
 */
@Entity
@Table(name = "CASSETTE_VIDEO")
public class CassetteVideo extends Ouvrage{

   
    @Column(name = "DUREE_CD")
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
