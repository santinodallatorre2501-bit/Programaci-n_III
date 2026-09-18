package modelo;
import javax.persistence.*;
@Entity
@Table(name = "contacto")
public class Contacto extends EntityId { //[cite: 1]
    private String email;
    private String telefono;
    private String celular;
}