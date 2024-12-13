package com.example.desarrollo_tp.model;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Puedes cambiar a JOINED o TABLE_PER_CLASS según el caso.
@DiscriminatorColumn(name = "tipo_item", discriminatorType = DiscriminatorType.STRING)
public abstract class ItemMenu {

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

    // Constructor ------------------------------------------------------------------------------------
    public ItemMenu(String nombre, String descripcion, double precio,boolean aptoVegano, boolean aptoCeliaco, Categoria categoria, Vendedor vendedor) {
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setAptoVegano(aptoVegano);
        setAptoCeliaco(aptoCeliaco);
        setCategoria(categoria);
        setVendedor(vendedor);
    }

    // Edición interna
    public void editarItem(String nombre, String descripcion, double precio, boolean aptoVegano, boolean aptoCeliaco, Categoria categoria, Vendedor vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aptoVegano = aptoVegano;
        this.aptoCeliaco = aptoCeliaco;
        this.categoria = categoria;
        this.vendedor = vendedor;
    }

    // Getters ----------------------------------------------------------------------------------------
    public int getId(){return this.id;}
    public String getNombre(){return this.nombre;}
    public String getDescripcion(){return this.descripcion;}
    public double getPrecio(){return this.precio;}
    public Categoria getCategoria(){return this.categoria;}
    public Vendedor getVendedor(){return this.vendedor;}
    public boolean getAptoVegano(){return this.aptoVegano;}
    public boolean getAptoCeliaco(){return this.aptoCeliaco;}
    // ------------------------------------------------------------------------------------------------

    // Setters ----------------------------------------------------------------------------------------
    public void setId(int id){this.id = id;}
    private void setNombre(String nombre){this.nombre = nombre;}
    private void setDescripcion(String descripcion){this.descripcion = descripcion;}
    private void setPrecio(double precio){this.precio = precio;}
    private void setCategoria(Categoria categoria){this.categoria = categoria;}
    private void setVendedor(Vendedor vendedor){this.vendedor = vendedor;}
    private void setAptoVegano(boolean aptoVegano){this.aptoVegano = aptoVegano;}
    private void setAptoCeliaco(boolean aptoCeliaco){this.aptoCeliaco = aptoCeliaco;}
    // ------------------------------------------------------------------------------------------------

    public abstract double peso();
    public abstract boolean esComida();
    public abstract boolean esBebida();
    public abstract boolean aptoVegano();
    public abstract boolean aptoCeliaco();



}
