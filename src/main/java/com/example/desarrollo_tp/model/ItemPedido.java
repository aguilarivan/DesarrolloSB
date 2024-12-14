package com.example.desarrollo_tp.model;

import jakarta.persistence.*;

@Entity
public class ItemPedido {
    // Atributos ------------------------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "item_menu_id")
    private ItemMenu itemMenu;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    // Constructor ------------------------------------------------------------------------------------------------------------------------------------
    public ItemPedido(){};
    public ItemPedido(ItemMenu itemMenu, Pedido pedido) {
        setItemMenu(itemMenu);
        setPedido(pedido);
    }

    // Getters ------------------------------------------------------------------------------------------------------------------------------------
    public ItemMenu getItemMenu() {return this.itemMenu;}
    public Pedido getPedido() {return this.pedido;}
    public int getId() {return this.id;}

    // Setters ------------------------------------------------------------------------------------------------------------------------------------
    private void setItemMenu(ItemMenu itemMenu) {this.itemMenu = itemMenu;}
    private void setPedido(Pedido pedido) {this.pedido = pedido;}

}
