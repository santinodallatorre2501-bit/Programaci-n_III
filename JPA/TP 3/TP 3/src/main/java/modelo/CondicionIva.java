package modelo;
import javax.persistence.*;
@Entity
@Table(name = "condicion_iva")
public class CondicionIva extends AuditoriaApp { //[cite: 1]
    @Column(nullable = false) //[cite: 1]
    private int codigoAfip;
    @Column(nullable = false) //[cite: 1]
    private String denominacion;
}