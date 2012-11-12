package enterprise.ProjetMediatheque.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 *
 * @author sbai
 */
@Entity
@DiscriminatorColumn(name="MAGAZINE")
@Table(name = "MAGAZINE")
public class Magazine extends Ouvrage{

    @Column(name = "NUMBER")
    private int numero;  
     
    /**
     * Creates a new instance of CD
     */
    public Magazine() {
    }

    public Magazine(int numero) {
        this.numero = numero;
    }
   
    public int getNumero() {
        return this.numero;
    }
      
}
