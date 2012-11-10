/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gilles
 */
@Entity
@Table (name="CONFIG")
public class Config {
    @Id
    @Column (name="YEAR_ID")
    private int annee;
    
    @Column (name="BASE_PENALTY")
    private String penaliteDeBase;
    
    @Column (name="BAIL")
    private String caution;
    
    @Column (name="MAX_NB_ITEM")
    private int nbMaxItem;

    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    public Config() {
    }

    public Config(int annee, String penaliteDeBase, String caution, int nbMaxItem) {
        this.annee = annee;
        this.penaliteDeBase = penaliteDeBase;
        this.caution = caution;
        this.nbMaxItem = nbMaxItem;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Accesseur">
    public int getAnnee() {
        return annee;
    }

    public String getPenaliteDeBase() {
        return penaliteDeBase;
    }

    public String getCaution() {
        return caution;
    }

    public int getNbMaxItem() {
        return nbMaxItem;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Modificateur">
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setPenaliteDeBase(String penaliteDeBase) {
        this.penaliteDeBase = penaliteDeBase;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public void setNbMaxItem(int nbMaxItem) {
        this.nbMaxItem = nbMaxItem;
    }
    // </editor-fold>
    
}
