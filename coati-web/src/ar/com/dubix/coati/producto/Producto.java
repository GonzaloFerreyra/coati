package ar.com.dubix.coati.producto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto implements Serializable {

    public static void init() {
        System.out.println("Llegue a mi clase!");
    }
    @Id
    private Long id;
    private String codigo;
    private String descripcion;
    private String marca;
    private BigDecimal precio;
    private BigDecimal precioConIva;
    private BigDecimal iva;
    private BigDecimal precioAlternativo;
    private BigDecimal precioAlternativo2;
    private String clase;

    /**
     * Constructor para Objectify
     */
    protected Producto() {
    }

    /**
     * Construye un producto en función de sus propiedades
     *
     * @param nombre
     * @param codigo
     */
    public Producto(final String codigo, final String descripcion,
            final String marca, final BigDecimal precio, final BigDecimal precioConIva,
            final BigDecimal iva, final BigDecimal precioAlternativo1,
            final BigDecimal precioAlternativo2, final String clase) {
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.marca = marca;
        this.precio = precio;
        this.precioConIva = precioConIva;
        this.iva = iva;
        this.precioAlternativo = precioAlternativo1;
        this.precioAlternativo2 = precioAlternativo2;
        this.clase = clase;

    }
}
