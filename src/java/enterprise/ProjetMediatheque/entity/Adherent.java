/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author guyader
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"LAST_NAME", "FIRST_NAME", "BIRTH_DATE"})})
public class Adherent implements Serializable {
    @Id
    @Column(name = "CARD_NUMBER")
    private int numCarte;
    
    @Column(name = "LAST_NAME")
    private String nom;
    
    @Column(name = "FIRST_NAME")
    private String prenom;
    
    @Column(name = "BIRTH_DATE")
    @Temporal(DATE)
    private Date dateNaissance;
    
    @Column(name = "PASSWORD")
    private String motDePasse; // en MD5 ?
    
    @Column(name = "SUBSCRIPTION_EXPIRY")
    @Temporal(DATE)
    private Date dateFinCotisation;
    
    @Column(name = "REGISTRATION_DATE")
    @Temporal(DATE)
    private Date dateAdhesion;
    
    @Column(name = "ACCOUNT_BALANCE")
    private int soldeCompte;
    
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Adresse adresse;
    
    @OneToMany(cascade = ALL, mappedBy = "CARD_NUMBER")
    private List<Emprunt> emprunts;
    
    @OneToMany(cascade = ALL, mappedBy = "CARD_NUMBER")
    private List<Reservation> reservations;
    
    public Adherent() {
        this.dateAdhesion = new Date();
        this.soldeCompte = 0;
        this.emprunts = new ArrayList<Emprunt>();
        this.reservations = new ArrayList<Reservation>();
    }
    
    public Adherent(
            ) {
        
    }
}
