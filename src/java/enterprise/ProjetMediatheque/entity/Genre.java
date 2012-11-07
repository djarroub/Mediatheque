package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author sbai
 */
@Entity
@Table(name = "GENRE")
public class Genre implements Serializable {

    @Id
    @Column(name = "NAME")
    private String name;
  
  
    
    /**
     * Creates a new instance of Genre
     */
    public Genre() {
    }

    public Genre(String name) {
        
        this.name = name;
               
    }

    public String getName() {
        return this.name;
    }
      
}
