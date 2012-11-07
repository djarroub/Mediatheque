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
@Table(name = "LIVRE")
public class Livre extends Ouvrage{

    
    @Column(name = "ISBN")
    private String isbn;
  
    @Column(name = "COLLECTION")
    private String collection;
  
    
    /**
     * Creates a new instance of DVD
     */
    public Livre() {
    }

    public Livre(int id, String isbn, String collection) {
        
        this.isbn = isbn;
        this.collection=collection;
               
    }

   
    public String getIsbn() {
        return this.isbn;
    }
      
    public String getCollection(){
        return this.collection;
    }
}


