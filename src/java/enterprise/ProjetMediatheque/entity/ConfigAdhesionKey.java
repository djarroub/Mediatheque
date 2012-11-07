/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;

/**
 * Clef primaire composite de l'entite ConfigAdhesion.
 * @author Gilles
 */
public class ConfigAdhesionKey implements Serializable{
    private Ville ville;
    private int age;

    // <editor-fold defaultstate="collapsed" desc="Constructeur">
    public ConfigAdhesionKey() {
    }

    public ConfigAdhesionKey(Ville ville, int age) {
        this.ville = ville;
        this.age = age;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Override des fonctions de Serialize">
    @Override
    public int hashCode(){
        return (ville + "" + age).hashCode();
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
                ConfigAdhesionKey autre = (ConfigAdhesionKey) obj;
                if (age != autre.getAge()) {
                    resultat = false;
                } else {
                    if (ville != autre.getVille()) {
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
        return ville + " - " + age;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Accesseur">
    public Ville getVille() {
        return ville;
    }

    public int getAge() {
        return age;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Modificateur">

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // </editor-fold>
    
}
