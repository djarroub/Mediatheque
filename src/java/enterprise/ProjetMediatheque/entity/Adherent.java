/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.UniqueConstraint;
import java.security.SecureRandom;
import javax.persistence.NamedQuery;

/**
 *
 * @author guyader
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"LAST_NAME", "FIRST_NAME", "BIRTH_DATE"})})
@SequenceGenerator(
        name = "MEMBER_SEQUENCE",
        sequenceName = "MEMBER_SEQUENCE",
        initialValue = 0,
        allocationSize = 1)
@NamedQuery(name = "Adherent.get", query = "SELECT a FROM Adherent a WHERE a.numCarte = :numCarte")
public class Adherent implements Serializable {
    @Id
    @Column(name = "CARD_NUMBER")
    @GeneratedValue(strategy=SEQUENCE, generator="MEMBER_SEQUENCE")
    private Long numCarte;
    
    @Column(name = "LAST_NAME")
    private String nom;
    
    @Column(name = "FIRST_NAME")
    private String prenom;
    
    @Column(name = "BIRTH_DATE")
    @Temporal(DATE)
    private Date dateNaissance;
    
    @Column(name = "PASSWORD")
    private String motDePasse;
    
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
    
    @OneToMany(cascade = ALL, mappedBy = "adherent")
    private List<Emprunt> emprunts;
    
    @OneToMany(cascade = ALL, mappedBy = "adherent")
    private List<Reservation> reservations;
    
    public Adherent() {}
    
    public Adherent(
            String _nom,
            String _prenom,
            Date _dateNaissance,
            Date _dateFinCotisation,
            int _soldeCompte,
            Adresse _adresse) {
        SecureRandom random = new SecureRandom();
        
        this.nom = _nom;
        this.prenom = _prenom;
        this.dateNaissance = _dateNaissance;
        this.motDePasse = new BigInteger(130, random).toString(8);
        this.dateFinCotisation = _dateFinCotisation;
        this.dateAdhesion = new Date();
        this.soldeCompte = _soldeCompte;
        this.adresse = _adresse;        
        this.emprunts = new ArrayList<Emprunt>();
        this.reservations = new ArrayList<Reservation>();
    }
    
    public Boolean isRightPassword(String pwd) {
        return this.motDePasse.equals(pwd);
    }

    // <editor-fold defaultstate="collapsed" desc="Accesseur">
    public Long getNumCarte() {
        return numCarte;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Date getDateFinCotisation() {
        return dateFinCotisation;
    }

    public Date getDateAdhesion() {
        return dateAdhesion;
    }

    public int getSoldeCompte() {
        return soldeCompte;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Modificateur">
    public void setNumCarte(Long numCarte) {
        this.numCarte = numCarte;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setDateFinCotisation(Date dateFinCotisation) {
        this.dateFinCotisation = dateFinCotisation;
    }

    public void setDateAdhesion(Date dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public void setSoldeCompte(int soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    // </editor-fold>
    
    
}
