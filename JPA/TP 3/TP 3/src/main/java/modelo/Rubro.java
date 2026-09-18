package modelo;
import javax.persistence.*;
@Entity
@Table(name = "rubro")
public class Rubro extends AuditoriaApp { //[cite: 1]
    @Column(nullable = false) //[cite: 1]
    private String denominacion;
    @Column(nullable = false) //[cite: 1]
    private Integer codigo;
}