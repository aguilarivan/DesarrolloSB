package com.example.desarrollo_tp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;

@Entity
public class Plato extends ItemMenu{

    private double calorias;
    private double peso;

    public Plato(String nombre, String descripcion, double precio, boolean aptoVegano, boolean aptoCeliaco, Categoria categoria, Vendedor vendedor, double calorias, double peso) {
        super(nombre, descripcion, precio, aptoVegano, aptoCeliaco, categoria, vendedor);
        this.calorias = calorias;
        this.peso = peso;
    }


    @Override
    public double peso() {return peso * 1.1;}
    public boolean esComida(){return true;}
    public boolean esBebida(){return false;}
    public boolean aptoVegano(){return this.isAptoCeliaco();}
    public boolean aptoCeliaco(){return this.isAptoVegano();}

    public void prueba(String nombre, String descripcion, double precio, boolean aptoVegano, boolean aptoCeliaco, Categoria categoria, Vendedor vendedor, double calorias, double peso){

      //  Plato p1 = new Plato(nombre, descripcion, precio, aptoVegano, aptoCeliaco, categoria, vendedor, calorias, peso);

    }
}
