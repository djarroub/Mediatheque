package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author sbai
 */
@Entity
@Table(name = "OUVRAGE")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(
        name = "WORK_SEQUENCE",
        sequenceName = "WORK_SEQUENCE",
        initialValue = 0,
        allocationSize = 1)
@NamedQuery(name = "Ouvrage.get", query = "SELECT o FROM Ouvrage o WHERE o.id = :id")
public class Ouvrage implements Serializable {

    @Id
    @Column(name = "ID_OUVRAGE")
    @GeneratedValue(strategy=SEQUENCE, generator="WORK_SEQUENCE")
    private Long id;

    @Column(name = "TITRE")
    private String titre;
  
    @Column(name = "DATE_PREMIERE_PUBLICATION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePremierePublication;
    
    //for joing the tables (many-to-many entre Genre et Ouvrage)
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "GENRE_OUVRAGE",
    joinColumns = {
    @JoinColumn(name="ID_OUVRAGE") 
    },
    inverseJoinColumns = {
    @JoinColumn(name="NOM_GENRE")
    }
    )
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;
    
    //for joing the tables (many-to-many entre Auteur et Ouvrage)
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "AUTEUR_OUVRAGE",
    joinColumns = {
    @JoinColumn(name="ID_OUVRAGE") 
    },
    inverseJoinColumns = {
    @JoinColumn(name="ID_AUTEUR")
    }
    )
    private Set<Auteur> auteurs;
    
    /**
     * Creates a new instance of Ouvrage
     */
    public Ouvrage() {
    }

    public Ouvrage(String titre, Date datePremierePublication, Set<Auteur> auteurs, Set<Genre> genres) {
        this.titre = titre;
        this.datePremierePublication=datePremierePublication;
        this.auteurs=auteurs;
        this.genres=genres;
        
    }

    public Long getId() {
        return this.id;
    }

    public String getTitre() {
        return this.titre;
    }

    public Date getDatePremierePublication(){
        return this.datePremierePublication;
    }
    
    public Set<Auteur> GetAuteurs(){
        return this.auteurs;
}
    public Set<Genre> GetGenre(){
        return this.genres;
    }
}
