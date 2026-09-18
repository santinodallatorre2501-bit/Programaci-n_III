package modelo;
import javax.persistence.*;
@Entity
@Table(name = "lista_precio_articulo")
public class ListaPrecioArticulo extends AuditoriaApp { //[cite: 1]
    @ManyToOne //[cite: 1]
    @JoinColumn(nullable = false)
    private ListaPrecio listaPrecio;

    @Column(nullable = false) //[cite: 1]
    private double precioVenta;

    @ManyToOne //[cite: 1]
    @JoinColumn(nullable = false)
    private Articulo articulo;

    public ListaPrecio getListaPrecio() {
        return listaPrecio;
    }

    public void setListaPrecio(ListaPrecio listaPrecio) {
        this.listaPrecio = listaPrecio;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}