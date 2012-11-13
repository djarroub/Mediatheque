/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Personnel
 */
@Entity
@DiscriminatorValue("CDS")
public class CD extends Ouvrage {
    
    @Column(name="CD_DURATION")
    private int dureeCD;
    
    public CD() {}
    
    public CD (
            Type type, 
            String titre, 
            Date datePremierePublication,
            List<Auteur> auteurs, 
            List<Genre> genres, 
            int dureeCD) {
        super(type, titre, datePremierePublication, auteurs, genres);
        this.dureeCD = dureeCD;
    }
    
    public String toString() {
        String s = super.toString();
        s += "Duree : " + this.dureeCD;
        
        return s;
    }
}

