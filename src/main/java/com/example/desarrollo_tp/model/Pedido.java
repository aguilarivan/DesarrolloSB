package com.example.desarrollo_tp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Transient
    private List<ItemPedido> itemsPedidos;
    // @ManyToOne
    // @JoinColumn(name = "estado_id")
    // private Estado estado;
    @ManyToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

}
