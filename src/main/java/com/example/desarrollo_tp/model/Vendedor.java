package com.example.desarrollo_tp.model;

import java.util.ArrayList;
import jakarta.persistence.*;
@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @OneToOne
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;
    @OneToOne
    @JoinColumn(name = "coordenadas_id")
    private Coordenada coordenadas;
    @Transient
    private ArrayList<ItemMenu> itemMenu;
    @Transient
    private ArrayList<Pedido> pedidos;
}
