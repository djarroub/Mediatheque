package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import java.util.Set;
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
@Table(name = "GENRE")
public class Genre implements Serializable {

    @Id
    @Column(name = "NOM_GENRE")
    private String nomGenre;
  
  
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "GENRE_OUVRAGE",
    joinColumns = {
    @JoinColumn(name="NOM_GENRE") 
    },
    inverseJoinColumns = {
    @JoinColumn(name="ID_OUVRAGE")
    }
    )
    private Set<Ouvrage> ouvrages;
    
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
      
    public Set<Ouvrage> getOuvrages() {
        
       return ouvrages;
    }
}
