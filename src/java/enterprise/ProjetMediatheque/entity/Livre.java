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
@DiscriminatorValue("BOOK")
@Table(name = "BOOKS")
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

    public Livre(Type type, 
            String titre, 
            Date datePremierePublication,
            List<Auteur> auteurs, 
            List<Genre> genres, 
            String isbn,
            String collection) {
        super(type, titre, datePremierePublication, auteurs, genres);
        this.isbn = isbn;
        this.collection=collection;               
    }
   
    public String getIsbn() {
        return this.isbn;
    }
      
    public String getCollection(){
        return this.collection;
    }
    
    public String toString() {
        String s = super.toString();
        s += "ISBN : " + this.isbn + "<br/>";
        s += "Collection : " + this.collection;
        
        return s;
    }
}