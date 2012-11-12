/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Personnel
 */
@Entity
@DiscriminatorColumn(name="CD")
public class CD extends Ouvrage {
    
    @Column(name="CD_DURATION")
    private int dureeCD;
    
    public CD() {}
}

