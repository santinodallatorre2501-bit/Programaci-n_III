package modelo;
import javax.persistence.*;
@Entity
@Table(name = "domicilio")
public class Domicilio extends EntityId { //[cite: 1]
    private String nombreCalle;
    private String numeroCalle;
}