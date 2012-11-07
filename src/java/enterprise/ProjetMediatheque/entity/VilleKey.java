/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;

/**
 *
 * @author Gilles
 */
public class VilleKey implements Serializable {

    private int codePostal;
    private String nomVille;
    
    public VilleKey() {
    }
    
    public VilleKey(int codePostal, String nomVille) {
        this.codePostal = codePostal;
        this.nomVille = nomVille;
    }

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
                if (codePostal != autre.codePostal) {
                    resultat = false;
                } else {
                    if (!nomVille.equals(autre.nomVille)) {
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

    // ---------------------------------
    //   Accesseur
    // ---------------------------------
    public int getCodePostal() {
        return codePostal;
    }
    
    public String getNomVille() {
        return nomVille;
    }
}
