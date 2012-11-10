package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Gilles
 */
@Entity
@IdClass(ConfigAdhesionKey.class)
@Table (name="CONFIG_MEMBERSHIP",uniqueConstraints = @UniqueConstraint(columnNames={"CITY_ID", "AGE"}))
public class ConfigAdhesion implements Serializable {
    @Id
    @ManyToOne
    @JoinColumns ({
        @JoinColumn (name="CITY_NAME", referencedColumnName="CITY_NAME"),
        @JoinColumn (name="POASTAL_CODE", referencedColumnName="POASTAL_CODE")
    })
    private Ville ville;
    
    @Id
    @Column (name="AGE")
    private int age;
    
    @Column (name="MEMBERSHIP_FEE")
    private double montantAdhesion;
    
    @Column (name="AMOUNT_CONTRIBUTION")
    private double montantCotisation;
    
    // <editor-fold defaultstate="collapsed" desc="Constructeur">
    public ConfigAdhesion() {
    }

    public ConfigAdhesion(Ville ville, int age, double montantAdhesion, double montantCotisation) {
        this.ville = ville;
        this.age = age;
        this.montantAdhesion = montantAdhesion;
        this.montantCotisation = montantCotisation;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Accesseur">
    public Ville getVille() {
        return ville;
    }

    public int getAge() {
        return age;
    }

    public double getMontantAdhesion() {
        return montantAdhesion;
    }

    public double getMontantCotisation() {
        return montantCotisation;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Modificateur">

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMontantAdhesion(double montantAdhesion) {
        this.montantAdhesion = montantAdhesion;
    }

    public void setMontantCotisation(double montantCotisation) {
        this.montantCotisation = montantCotisation;
    }
    // </editor-fold>
}
