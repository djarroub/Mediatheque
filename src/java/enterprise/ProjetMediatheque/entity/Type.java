package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sbai
 */

@Entity
@Table(name = "TYPES")
@NamedQuery(name="Type.Get", query="SELECT t FROM Type t WHERE t.nom = :nom")
public class Type implements Serializable {

    @Id
    @Column(name = "NAME")
    @Enumerated(EnumType.STRING)
    private TypeName nom;

    @Column(name = "MAX_BORROWING_DURATION")
    private int dureeEmpruntMax;
  
    @Column(name = "MAX_BORROWING_NUMBER")
    private int nbEmpruntMax;
    
    /**
     * Creates a new instance of Type
     */
    public Type() {
    }

    public Type(String nom, int dureeEmpruntMax, int nbEmpruntMax) {
        this.nom= TypeName.valueOf(nom);
        this.dureeEmpruntMax= dureeEmpruntMax;
        this.nbEmpruntMax=nbEmpruntMax;
    }

    public String getNom() {
        return this.nom.toString();
    }

    public int getDureeEmpruntMax() {
        return this.dureeEmpruntMax;
    }

    public int getNbEmpruntMax(){
        return this.nbEmpruntMax;
    }
    
}
