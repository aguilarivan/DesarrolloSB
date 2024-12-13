package com.example.desarrollo_tp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Coordenada {

    @Id
    private double lat;
    private double lng;

}
