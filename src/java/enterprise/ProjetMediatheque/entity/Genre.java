package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 *
 * @author sbai
 */
@Entity
@Table(name = "GENRES")
public class Genre implements Serializable {

    @Id
    @Column(name = "GENRE_NAME")
    private String nomGenre;
  
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "WORK_GENRE",
        joinColumns = {
            @JoinColumn(name="GENRE_NAME") 
        },
        inverseJoinColumns = {
            @JoinColumn(name="WORK_ID")
        }
    )
    private List<Ouvrage> ouvrages;
    
    /**
     * Creates a new instance of Genre
     */
    public Genre() {
    }

    public Genre(String nomGenre) {
        this.nomGenre = nomGenre;
    }

    public String getNomGenre() {
        return this.nomGenre;
    }
      
    public List<Ouvrage> getOuvrages() {
        
       return ouvrages;
    }
}
