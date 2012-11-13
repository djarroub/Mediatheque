package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.FetchType;
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
import javax.persistence.ManyToOne;

/**
 *
 * @author sbai
 */
@Entity
@Table(name = "WORKS")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="WORK_INH", discriminatorType=DiscriminatorType.STRING,length=20)
@DiscriminatorValue("WORK")
@SequenceGenerator(
        name = "WORK_SEQUENCE",
        sequenceName = "WORK_SEQUENCE",
        initialValue = 0,
        allocationSize = 1)
@NamedQuery(name = "Ouvrage.get", query = "SELECT o FROM Ouvrage o WHERE o.id = :id")
public class Ouvrage implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=SEQUENCE, generator="WORK_SEQUENCE")
    private Long id;

    @Column(name = "TITLE")
    private String titre;
  
    @Column(name = "FIRST_PUBLISHED_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePremierePublication;
    
    //for joing the tables (many-to-many entre Genre et Ouvrage)
    @ManyToMany(fetch=FetchType.EAGER, 
            mappedBy="ouvrages")
    @JoinTable(name = "WORK_GENRE",
        joinColumns = {
            @JoinColumn(name="WORK_ID", referencedColumnName="ID") 
        },
        inverseJoinColumns = {
            @JoinColumn(name="GENRE_NAME", referencedColumnName="NAME")
        }
    )
    private List<Genre> genres;
    
    //for joing the tables (many-to-many entre Auteur et Ouvrage)
    @ManyToMany(fetch=FetchType.EAGER, 
            mappedBy="ouvrages")
    @JoinTable(name = "WORK_AUTHOR",
        joinColumns = {
            @JoinColumn(name="WORK_ID") 
        },
        inverseJoinColumns = {
            @JoinColumn(name="AUTHOR_ID")
        }
    )
    private List<Auteur> auteurs;
    
    @Column(name="IS_NEW")
    private Boolean estNouveaute;
    
    @ManyToOne
    @JoinColumn(name="TYPE_NAME")
    private Type type;
    /**
     * Creates a new instance of Ouvrage
     */
    public Ouvrage() {
    }

    public Ouvrage(Type type, String titre, Date datePremierePublication, List<Auteur> auteurs, List<Genre> genres) {
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
    
    public List<Auteur> getAuteurs(){
        return this.auteurs;
}
    public List<Genre> getGenres(){
        return this.genres;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public String toString() {
        String s = "Type : " + getType().getNom() + "<br/>"
                + "Date de 1ère publication : " + getDatePremierePublication() + "<br/>"
                + "Auteurs : <br/>";
        for (Auteur a : getAuteurs())
            s += "&nbsp;&nbsp;" + a.getPrenom() + " " + a.getNom() + "<br/>";
        s += "Genres : <br/>";
        for (Genre g : getGenres())
            s += "&nbsp;&nbsp;" + g.getNomGenre() + "<br/>";
        return s;
    }
}
