package com.example.desarrollo_tp.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("PLATO")
public class Plato extends ItemMenu{
    // Atributos --------------------------------------------------------------------------------------------------------------------------------------
    private double calorias;
    private double peso;

    // Constructor ------------------------------------------------------------------------------------------------------------------------------------
    public Plato(){}
    public Plato(String nombre, String descripcion, double precio, boolean aptoVegano, boolean aptoCeliaco, Categoria categoria, Vendedor vendedor, double calorias, double peso) {
        super(nombre, descripcion, precio, aptoVegano, aptoCeliaco, categoria, vendedor);
        this.calorias = calorias;
        this.peso = peso;
    }

    // Getters -----------------------------------------------------------------------------------------------------------------------------------------
    public double getCalorias() {return calorias;}
    public double getPeso() {return peso;}

    // Setters -----------------------------------------------------------------------------------------------------------------------------------------
    public void setCalorias(double calorias) {this.calorias = calorias;}
    public void setPeso(double peso) {this.peso = peso;}

    // Methods -----------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public double peso() {return peso * 1.1;}
    public boolean esComida(){return true;}
    public boolean esBebida(){return false;}
    public boolean aptoVegano(){return this.isAptoVegano();}
    public boolean aptoCeliaco(){return this.isAptoCeliaco();}
    public void editarItem(String nombre, String descripcion, double precio, boolean aptoVegano, boolean aptoCeliaco, Categoria categoria, Vendedor vendedor, double calorias, double peso) {
        super.editarItem(nombre, descripcion, precio, aptoVegano, aptoCeliaco, categoria, vendedor);
        setCalorias(calorias);
        setPeso(peso);
    }
}
