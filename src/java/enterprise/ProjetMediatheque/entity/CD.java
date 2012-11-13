/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Personnel
 */
@Entity
@DiscriminatorValue("CD")
public class CD extends Ouvrage {
    
    @Column(name="CD_DURATION")
    private int dureeCD;
    
    public CD() {}
}

