package com.example.desarrollo_tp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Direccion")
public class Direccion {

    @Id
    private String calle;
    private int altura;
    private String ciudad;
    private String pais;

}
