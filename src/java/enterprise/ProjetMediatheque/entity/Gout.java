/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gilles
 */
@Entity
@Table (name="TASTES")
public class Gout implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="TASTE_TITLE")
    private String titreGout;
    
    @Column(name="TASTE_AUTHOR")
    private String auteurGout;
    
    @Column(name="TASTE_KIND")
    private String genreGout;
    
    @Column(name="TASTE_MEMBER_AGE")
    private int ageAdherentGout;

    @Column(name="IS_IN_LIBRARY")
    private boolean estDansMediatheque;
    
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide de la classe Gout.
     */
    public Gout() {}
    
    /**
     * Constructeur de la classe Gout.
     * @param id L'id de la classe Gout dans la BDD.
     * @param titreGout L'intitule du gout.
     * @param auteurGout 
     * @param genreGout
     * @param ageAdherentGout 
     * @param estDansMediatheque
     */
    public Gout(Long id, String titreGout, String auteurGout, String genreGout, int ageAdherentGout, boolean estDansMediatheque) {
        this.id = id;
        this.titreGout = titreGout;
        this.auteurGout = auteurGout;
        this.genreGout = genreGout;
        this.ageAdherentGout = ageAdherentGout;
        this.estDansMediatheque = estDansMediatheque;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Accesseurs">
    public Long getId() {
        return id;
    }

    public String getTitreGout() {
        return titreGout;
    }

    public String getAuteurGout() {
        return auteurGout;
    }

    public String getGenreGout() {
        return genreGout;
    }

    public int getAgeAdherentGout() {
        return ageAdherentGout;
    }
    
    public boolean getEstDansMediatheque(){
        return estDansMediatheque;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Modificateurs">
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitreGout(String titreGout) {
        this.titreGout = titreGout;
    }

    public void setAuteurGout(String auteurGout) {
        this.auteurGout = auteurGout;
    }

    public void setGenreGout(String genreGout) {
        this.genreGout = genreGout;
    }

    public void setAgeAdherentGout(int ageAdherentGout) {
        this.ageAdherentGout = ageAdherentGout;
    }

    public void setEstDansMediatheque(boolean estDansMediatheque) {
        this.estDansMediatheque = estDansMediatheque;
    }
    // </editor-fold>
}