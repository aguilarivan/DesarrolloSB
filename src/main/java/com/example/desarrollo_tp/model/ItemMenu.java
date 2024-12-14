package com.example.desarrollo_tp.model;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Plato.class, name = "plato"),
        @JsonSubTypes.Type(value = Bebida.class, name = "bebida")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_item", discriminatorType = DiscriminatorType.STRING)
public abstract class ItemMenu {
    // Atributos ------------------------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean aptoVegano;
    private boolean aptoCeliaco;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    // Constructor -------------------------------------------------------------------------------------------------------------------------------------
    public ItemMenu() {}
    public ItemMenu(String nombre, String descripcion, double precio,boolean aptoVegano, boolean aptoCeliaco, Categoria categoria, Vendedor vendedor) {
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setAptoVegano(aptoVegano);
        setAptoCeliaco(aptoCeliaco);
        setCategoria(categoria);
        setVendedor(vendedor);
    }
    // Getters ------------------------------------------------------------------------------------------------------------------------------------------
    public int getId(){return this.id;}
    public String getNombre(){return this.nombre;}
    public String getDescripcion(){return this.descripcion;}
    public double getPrecio(){return this.precio;}
    public Categoria getCategoria(){return this.categoria;}
    public Vendedor getVendedor(){return this.vendedor;}
    public boolean isAptoVegano(){return this.aptoVegano;}
    public boolean isAptoCeliaco(){return this.aptoCeliaco;}

    // Setters ------------------------------------------------------------------------------------------------------------------------------------------
    public void setId(int id){this.id = id;}
    private void setNombre(String nombre){this.nombre = nombre;}
    private void setDescripcion(String descripcion){this.descripcion = descripcion;}
    private void setPrecio(double precio){this.precio = precio;}
    public void setCategoria(Categoria categoria){this.categoria = categoria;}
    public void setVendedor(Vendedor vendedor){this.vendedor = vendedor;}
    private void setAptoVegano(boolean aptoVegano){this.aptoVegano = aptoVegano;}
    private void setAptoCeliaco(boolean aptoCeliaco){this.aptoCeliaco = aptoCeliaco;}

    // Métodos -----------------------------------------------------------------------------------------------------------------------------------------
    public void editarItem(String nombre, String descripcion, double precio, boolean aptoVegano, boolean aptoCeliaco, Categoria categoria, Vendedor vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aptoVegano = aptoVegano;
        this.aptoCeliaco = aptoCeliaco;
        this.categoria = categoria;
        this.vendedor = vendedor;
    }
    public abstract double peso();
    public abstract boolean esComida();
    public abstract boolean esBebida();
    public abstract boolean aptoVegano();
    public abstract boolean aptoCeliaco();
    public void printItemMenu(){System.out.println("ID: " + getId() + " | Nombre: " + getNombre() + " | Precio: " + getPrecio());}

}
