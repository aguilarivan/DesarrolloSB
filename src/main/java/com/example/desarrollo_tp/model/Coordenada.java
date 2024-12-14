package com.example.desarrollo_tp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coordenada {
    // Atributos ------------------------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private double lat;
    private double lng;

    // Constructor ------------------------------------------------------------------------------------------------------------------------------------
    public Coordenada(){};
    public Coordenada(double lat, double lng) {setLat(lat);setLng(lng);}

    //Getters ----------------------------------------------------------------------------------------------------------------------------------------
    public double getLat() {return lat;}
    public double getLng() {return lng;}

    //Setters ------------------------------------------------------------------------------------------------------------------------------------
    private void setLat(double lat) {this.lat = lat;}
    private void setLng(double lng) {this.lng = lng;}

}
