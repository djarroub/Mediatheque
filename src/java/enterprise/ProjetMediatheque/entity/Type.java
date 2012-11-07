package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author sbai
 */
@Entity
@Table(name = "TYPE")
public class Type implements Serializable {

    @Id
    @Column(name = "NOM")
    private String nom;

    @Column(name = "DUREE_EMPRUNT_MAX")
    private String dureeEmpruntMax;
  
    @Column(name = "NB_EMPRUNT_MAX")
    private int nbEmpruntMax;
    
    
    /**
     * Creates a new instance of Ouvrage
     */
    public Type() {
    }

    public Type(String nom, String dureeEmpruntMax, int nbEmpruntMax) {
        this.nom= nom;
        this.dureeEmpruntMax= dureeEmpruntMax;
        this.nbEmpruntMax=nbEmpruntMax;
        
    }

    public String getNom() {
        return this.nom;
    }

    public String getDureeEmpruntMax() {
        return this.dureeEmpruntMax;
    }

    public int getNbEmpruntMax(){
        return this.nbEmpruntMax;
    }
    
}
