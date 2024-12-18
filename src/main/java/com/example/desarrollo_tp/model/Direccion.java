package com.example.desarrollo_tp.model;

import jakarta.persistence.*;

@Entity
public class Direccion {

    // Atributos ------------------------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String calle;
    private int altura;
    private String ciudad;
    private String pais;

    // Constructor ----------------------------------------------------------------------------------------------------------------------------------
    public Direccion(){};
    public Direccion(String calle, int altura, String ciudad, String pais) {
        setCalle(calle);
        setAltura(altura);
        setCiudad(ciudad);
        setPais(pais);
    }

    // Getters ----------------------------------------------------------------------------------------------------------------------------------
    public String getCiudad() {return ciudad;}
    public String getPais() {return pais;}
    public int getAltura() {return altura;}
    public String getCalle() {return calle;}

    // Setters ----------------------------------------------------------------------------------------------------------------------------------
    public void setAltura(int altura) {this.altura = altura;}
    public void setCiudad(String ciudad) {this.ciudad = ciudad;}
    public void setPais(String pais) {this.pais = pais;}
    public void setCalle(String calle) {this.calle = calle;}

}
