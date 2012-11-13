package enterprise.ProjetMediatheque.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 *
 * @author sbai
 */
@Entity
@DiscriminatorValue("MAGAZINE")
@Table(name = "MAGAZINES")
public class Magazine extends Ouvrage{

    @Column(name = "NUMBER")
    private int numero;  
     
    /**
     * Creates a new instance of CD
     */
    public Magazine() {
    }

    public Magazine(Type type, 
            String titre, 
            Date datePremierePublication,
            List<Auteur> auteurs, 
            List<Genre> genres, 
            int numero) {
        super(type, titre, datePremierePublication, auteurs, genres);
        this.numero = numero;
    }
   
    public int getNumero() {
        return this.numero;
    }
    
    public String toString() {
        String s = super.toString();
        s += "Numero : " + this.numero;
        
        return s;
    }
}
