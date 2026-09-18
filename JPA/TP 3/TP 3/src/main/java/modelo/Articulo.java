package modelo;
import javax.persistence.*;

@Entity
@Table(name = "articulo")
public class Articulo extends AuditoriaApp { //[cite: 1]
    @ManyToOne //[cite: 1]
    private Rubro rubro;

    @Column(nullable = false) //[cite: 1]
    private String codigo;
    @Column(nullable = false) //[cite: 1]
    private String denominacion;

    @ManyToOne //[cite: 1]
    private Marca marca;

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}