package modelo;
import javax.persistence.*;
@Entity
@Table(name = "tipo_moneda")
public class TipoMoneda extends AuditoriaApp { //[cite: 1]
    @Column(nullable = false) //[cite: 1]
    private String codigoAfip;
    @Column(nullable = false) //[cite: 1]
    private String denominacion;
    @Column(nullable = false) //[cite: 1]
    private String simbolo;
}