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
@DiscriminatorValue("DVD")
@Table(name = "DVDS")
public class DVD extends Ouvrage{

    @Column(name = "LANGUAGE")
    private String langue;
  
    @Column(name = "FORMAT")
    private String format;
  
    
    /**
     * Creates a new instance of DVD
     */
    public DVD() {
    }

    public DVD(Type type, 
            String titre, 
            Date datePremierePublication,
            List<Auteur> auteurs, 
            List<Genre> genres, 
            String langue,
            String format) {
        super(type, titre, datePremierePublication, auteurs, genres);
        this.langue = langue;
        this.format=format;
               
    }

    public String getLangue() {
        return this.langue;
    }
      
    public String getFormat(){
        return this.format;
    }
    
    public String toString() {
        String s = super.toString();
        s += "Langue : " + langue + "<br/>";
        s += "Format : " + format;
        
        return s;
    }
}


