/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import javax.persistence.OneToOne;
import java.util.Date;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author guyader
 */
@Entity
public class Emprunt {
    @Id
    @Column(name = "ID")
    private int id;
    
    @Column(name = "BEGINNING_DATE")
    @Temporal(DATE)
    private Date dateDebut;
    
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Adherent adherent;
    
    @OneToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
}
