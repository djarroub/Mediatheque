package enterprise.ProjetMediatheque.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gilles
 */
@Entity
@Table (name="ADRESS")
public class Adresse implements Serializable {
    @Id @Column (name="ID")
    private Long id;
    
    @Column (name="STREET")
    private String rue;
    
    @Column (name="CITY")
    private Ville ville;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
