package enterprise.ProjetMediatheque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author sbai
 */
@Entity
@Table(name = "MAGAZINE")
public class Magazine extends Ouvrage{

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NUMERO")
    private int numero;
  
     
    /**
     * Creates a new instance of CD
     */
    public Magazine() {
    }

    public Magazine(int id, int numero) {
        this.id = id;
        this.numero = numero;
               
    }

   
    public int getNumero() {
        return this.numero;
    }
      
}
