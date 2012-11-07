/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author guyader
 */
@Entity
@SequenceGenerator(
        name = "RESERVATION_SEQUENCE",
        sequenceName = "RESERVATION_SEQUENCE",
        initialValue = 0,
        allocationSize = 1)
public class Reservation {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=SEQUENCE, generator="RESERVATION_SEQUENCE")
    private int id;
    
    @Column(name = "RESERVATION_DATE")
    @Temporal(DATE)
    private Date dateDeReservation;
    
    @Column(name = "EXPIRY_DATE")
    @Temporal(DATE)
    private Date dateDExpiration; // renommee depuis DateFinDeValidite
    
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Adherent adherent;
    
    @ManyToOne
    @JoinColumn(name = "WORK_ID")
    private Ouvrage ouvrage;
}
