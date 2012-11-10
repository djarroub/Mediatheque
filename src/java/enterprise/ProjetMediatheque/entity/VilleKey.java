/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;

/**
 * Clef primaire composite de l'entite Ville.
 * @author Gilles
 */
public class VilleKey implements Serializable {
    private int codePostal;
    private String nomVille;
    
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    /**
     * Constructeur vide de la classe VilleKey.
     */
    public VilleKey() {
    }
    
    /**
     * Constructeur de la classe VilleKey.
     * @param codePostal Le code postal de la Ville.
     * @param nomVille Le nom de la Ville.
     */
    public VilleKey(int codePostal, String nomVille) {
        this.codePostal = codePostal;
        this.nomVille = nomVille;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Override des fonctions de Serialize">
    @Override
    public int hashCode() {
        return (codePostal + nomVille).hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean resultat = false;
        if (obj == this) {
            resultat = true;
        } else {
            if (!(obj instanceof VilleKey)) {
                resultat = false;
            } else {
                VilleKey autre = (VilleKey) obj;
                if (codePostal != autre.getCodePostal()) {
                    resultat = false;
                } else {
                    if (!nomVille.equals(autre.getNomVille())) {
                        resultat = false;
                    } else {
                        resultat = true;
                    }
                }
            }
        }
        return resultat;
    }
    
    @Override
    public String toString() {
        return nomVille + " - " + codePostal;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Accesseurs">
    public int getCodePostal() {
        return codePostal;
    }
    
    public String getNomVille() {
        return nomVille;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Modificateurs">
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }
    // </editor-fold>
}
