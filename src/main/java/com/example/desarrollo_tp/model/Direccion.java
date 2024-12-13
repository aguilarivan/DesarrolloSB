package com.example.desarrollo_tp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String calle;
    private int altura;
    private String ciudad;
    private String pais;

}
