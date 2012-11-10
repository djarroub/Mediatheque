/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import java.util.Date;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author guyader
 */
@Entity
@Table(name = "BORROWINGS")
@SequenceGenerator(
        name = "BORROWING_SEQUENCE",
        sequenceName = "BORROWING_SEQUENCE",
        initialValue = 0,
        allocationSize = 1)
public class Emprunt {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=SEQUENCE, generator="BORROWING_SEQUENCE")
    private Long id;
    
    @Column(name = "BEGINNING_DATE")
    @Temporal(DATE)
    private Date dateDebut;
    
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Adherent adherent;
    
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    
    @Column(name = "IS_BACK")
    private Boolean estRentre;
    
    public Emprunt() {}
    
    public Emprunt(
            Adherent _adherent,
            Item _item) {
        this.adherent = _adherent;
        this.item = _item;
        this.dateDebut = new Date();
        this.estRentre = false;
    }
}
