/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author guyader
 */
public class Reservation {
    @Id
    @Column(name = "ID")
    private int id;
    
    @Column(name = "RESERVATION_DATE")
    private Date dateDeReservation;
    
    @Column(name = "EXPIRY_DATE")
    private Date dateDExpiration; // renommee depuis DateFinDeValidite
    
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Adherent adherent;
    
    @ManyToOne
    @JoinColumn(name = "WORK_ID")
    private Ouvrage ouvrage;
}
