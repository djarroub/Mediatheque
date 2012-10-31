/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Gilles
 */
@Entity
@Table (name="CITY")
public class Ville {
    //TODO : Mettre en place une cle primaire composee
    // voir lien : http://www.jmdoudoux.fr/java/dej/chap-jpa.htm
    @Column (name="POSTAL_CODE")
    @JoinColumn(table = "TABLE_1",name = "CLE_TABLE_1")
    private int codePostale;
    
    @Column (name="CITY_NAME")
    @JoinColumn(table = "TABLE_2",name = "CLE_TABLE_2")
    private String nomVille;
    
}
