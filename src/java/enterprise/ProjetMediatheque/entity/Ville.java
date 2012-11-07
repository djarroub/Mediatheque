/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Gilles
 */
@Entity
@IdClass(VilleKey.class)
@Table (name="CITY",uniqueConstraints = @UniqueConstraint(columnNames={"POSTAL_CODE", "CITY_NAME"}))
public class Ville implements Serializable {
    @Id @Column (name="POSTAL_CODE")
    private int codePostal;
    
    @Id @Column (name="CITY_NAME")
    private String nomVille;

    
    // <editor-fold defaultstate="collapsed" desc="Constructeur">
    /**
     * Constructeur vide de la classe Ville.
     */
    public Ville(){}

    /**
     * Constructeur de la classe Ville.
     * @param codePostale Le code postale associee a la Ville.
     * @param nomVille Le nom de la Ville.
     */
    public Ville(int codePostale, String nomVille) {
        this.codePostal = codePostale;
        this.nomVille = nomVille;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Accesseur">
    /**
     * 
     * @return Le code postale associee a la Ville.
     */
    public int getCodePostal() {
        return codePostal;
    }
    
    /**
     * 
     * @return Le nom de la Ville.
     */
    public String getNomVille() {
        return nomVille;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Modificateur">
    /**
     * 
     * @param codePostal Le nouveau code postal de la Ville
     */
    public void setCodePostale(int codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * 
     * @param nomVille Le nouveau de la Ville.
     */
    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }
    // </editor-fold>
}
