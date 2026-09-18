package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // 1. Iniciar el contenedor de JPA y obtener el EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FacturacionPU"); //
        EntityManager em = emf.createEntityManager(); //[cite: 1]

        try {
            em.getTransaction().begin();

            // 1. Crear y guardar el Usuario de auditoría
            Usuario usuario = new Usuario();
            usuario.setUsuario("admin");
            usuario.setClave("1234");
            usuario.setNombre("Juan");
            usuario.setApellido("Perez");
            em.persist(usuario);

            // 2. Crear y guardar el Punto de Venta asignándole el usuario
            PuntoVenta puntoVenta = new PuntoVenta();
            puntoVenta.setNumero(10);
            puntoVenta.setFechaAlta(new Date());
            puntoVenta.setFechaModificacion(new Date());
            puntoVenta.setUsuarioCarga(usuario); // Solución al error principal
            puntoVenta.setUsuarioModificacion(usuario);
            em.persist(puntoVenta);

            // 3. Crear y guardar dependencias del Artículo
            Articulo articulo = new Articulo();
            articulo.setCodigo("A001");
            articulo.setDenominacion("Teclado Mecánico");
            articulo.setFechaAlta(new Date());
            articulo.setFechaModificacion(new Date());
            articulo.setUsuarioCarga(usuario);
            articulo.setUsuarioModificacion(usuario);
            em.persist(articulo);

            ListaPrecio lista = new ListaPrecio();
            lista.setCodigo("L1");
            lista.setDenominacion("General");
            lista.setFechaAlta(new Date());
            lista.setFechaModificacion(new Date());
            lista.setUsuarioCarga(usuario);
            lista.setUsuarioModificacion(usuario);
            em.persist(lista);

            ListaPrecioArticulo lpa = new ListaPrecioArticulo();
            lpa.setPrecioVenta(50000.0);
            lpa.setArticulo(articulo);
            lpa.setListaPrecio(lista);
            lpa.setFechaAlta(new Date());
            lpa.setFechaModificacion(new Date());
            lpa.setUsuarioCarga(usuario);
            lpa.setUsuarioModificacion(usuario);
            em.persist(lpa);

            // 4. Crear la Factura
            FacturaVenta factura = new FacturaVenta();
            factura.setFechaEmision(new Date());
            factura.setEstado("EMITIDA");
            factura.setImporteTotal(50000.0);
            factura.setImporteCobrado(50000.0);
            factura.setImporteSaldo(0.0);
            factura.setPuntoVenta(puntoVenta);
            factura.setFechaAlta(new Date());
            factura.setFechaModificacion(new Date());
            factura.setUsuarioCarga(usuario);
            factura.setUsuarioModificacion(usuario);
            factura.setDetalles(new java.util.ArrayList<>());

            // 5. Crear el detalle y vincularlo
            FacturaVentaDetalle detalle1 = new FacturaVentaDetalle();
            detalle1.setCantidad(1);
            detalle1.setPrecioUnitario(50000.0);
            detalle1.setImporteSubtotal(50000.0);
            detalle1.setImporteNeto(50000.0);
            detalle1.setImporteIva(0.0);
            detalle1.setPorcentajeBonificacion(0.0);
            detalle1.setListaPrecioArticulo(lpa);
            detalle1.setFactura(factura);

            factura.getDetalles().add(detalle1);

            // 6. Persistir en cascada
            em.persist(factura);

            em.getTransaction().commit();
            System.out.println("¡Factura y detalles guardados con éxito!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}