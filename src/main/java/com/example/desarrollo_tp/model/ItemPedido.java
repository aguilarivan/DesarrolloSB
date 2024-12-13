package com.example.desarrollo_tp.model;

import jakarta.persistence.*;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "item_menu_id")
    private ItemMenu itemMenu;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;


}
