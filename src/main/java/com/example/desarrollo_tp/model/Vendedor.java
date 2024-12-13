package com.example.desarrollo_tp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vendedor {

    @Id
    private int id;
    private String nombre;
    //private Direccion direccion;
    //private Coordenada coordenadas;
    //private ArrayList<ItemMenu> itemMenu;
    //private ArrayList<Pedido> pedidos;
}
