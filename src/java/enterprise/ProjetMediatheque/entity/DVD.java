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
@Table(name = "DVD")
public class DVD extends Ouvrage{

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "LANGUE")
    private String langue;
  
    @Column(name = "FORMAT")
    private String format;
  
    
    /**
     * Creates a new instance of DVD
     */
    public DVD() {
    }

    public DVD(int id, String langue, String format) {
        this.id = id;
        this.langue = langue;
        this.format=format;
               
    }

    public String getLangue() {
        return this.langue;
    }
      
    public String getFormat(){
        return this.format;
    }
}


