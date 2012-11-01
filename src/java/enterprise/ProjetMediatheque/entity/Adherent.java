/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author guyader
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"NOM", "PRENOM", "DATE_NAISSANCE"})})
public class Adherent implements Serializable {
    @Id
    @Column(name = "NUM_CARTE")
    private int numCarte;
    
    @Column(name = "NOM")
    private String nom;
    
    @Column(name = "PRENOM")
    private String prenom;
    
    @Column(name = "DATE_NAISSANCE")
    private int dateNaissance; // Timestamp
    
    @Column(name = "MOT_DE_PASSE")
    private String motDePasse; // en MD5 ?
    
    @Column(name = "DATE_FIN_COTISATION")
    private int dateFinCotisation; // Timestamp
    
    @Column(name = "DATE_ADHESION")
    private int dateAdhesion; // Timestamp
    
    @Column(name = "SOLDE_COMPTE")
    private int soldeCompte;
    
    @ManyToOne
    private Adresse adresse;
}
