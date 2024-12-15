package com.example.desarrollo_tp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @Entity
public class Pedido extends EventManager {
    // Atributos ---------------------------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // Evita la recursión infinita aquí
    private List<ItemPedido> itemsPedidos;
    @Enumerated(EnumType.STRING)  // Almacena el nombre del enum como texto en la base de datos
    private Estado estado;
    @ManyToOne
    @JoinColumn(name = "pago_id", nullable = true)
    private Pago pago;
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    // Constructor ------------------------------------------------------------------------------------------------------------------------------------
    public Pedido(){};
    public Pedido(Cliente cliente, Vendedor vendedor, Pago pago, Estado estado) {
        super();
        setCliente(cliente);
        setPago(pago);
        setVendedor(vendedor);
        itemsPedidos = new ArrayList<>();
        setEstado(estado);
    }
    public Pedido(Cliente cliente, List<ItemPedido> itemsPedidos, Vendedor vendedor, Pago pago) {
        super();
        setCliente(cliente);
        setItemsPedidos(itemsPedidos);
        setVendedor(vendedor);
        setPago(pago);
    }

    // Getters -----------------------------------------------------------------------------------------------------------------------------------------
    public Cliente getCliente() {return cliente;}
    public List<ItemPedido> getItemsPedidos() {return itemsPedidos;}
    public Pago getPago() {return this.pago;}
    public int getId() {return id;}
    public Estado getEstado() {return estado;}
    public Vendedor getVendedor() {return vendedor;}

    // Setters ------------------------------------------------------------------------------------------------------------------------------------------
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.addEventListener(cliente);
    }
        public void setItemsPedidos(List<ItemPedido> itemsPedidos) {
            this.itemsPedidos = itemsPedidos;
            for (ItemPedido item : itemsPedidos) {
                item.setPedido(this);  // Establece la relación inversa
            }
        }

        public void setPago(Pago pago) {this.pago = pago;}
    public void addItemPedido(ItemPedido itemPedido) {
        itemsPedidos.add(itemPedido);
        itemPedido.setPedido(this);  // Establece la relación bidireccional
    }

    public void setId(int id) {this.id = id;}
    public void setVendedor(Vendedor vendedor) {this.vendedor = vendedor;}
    public void setEstado(Estado estado) {this.estado = estado;}

    // Methods -----------------------------------------------------------------------------------------------------------------------------------------


    public double calcularPrecioBase() {
        double precioBase = 0;
        for (ItemPedido itemPedido : itemsPedidos) {
            precioBase += itemPedido.getItemMenu().getPrecio();
        }
        return precioBase;
    }
    public double precioTotal() {return pago.getMonto();}

    //public void pagarPagoStrategy(PagoStrategy ps) {
    //    this.setPago(new Pago(ps, calcularPrecioBase()));
    //}

    public void printItemsPedidos() {
        for (ItemPedido itemPedido : itemsPedidos) {
            System.out.println(itemPedido.getItemMenu().getNombre());
        }
    }
    public void printAllPedido() {
        System.out.println("Pedido de ID: " + this.getId());
        this.printItemsPedidos();
        System.out.println(this.cliente.getNombre());
    }
    //public void removeItemPedido(ItemPedido itemPedido) {}
    @Override
    public boolean equals(Object obj) {
        Pedido pedido = (Pedido) obj;
        return pedido.getId() == this.getId();
    }
}
