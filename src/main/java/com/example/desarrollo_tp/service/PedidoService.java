package com.example.desarrollo_tp.service;

import com.example.desarrollo_tp.model.*;
import com.example.desarrollo_tp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    //POST CLIENTE -- crear pedido
    public Pedido crearPedido(Vendedor vendedor, Cliente cliente, Pago pago){
        Pedido pedido = new Pedido(cliente,vendedor, pago, new EstadoRECIBIDO());
        return pedidoRepository.save(pedido);
    }

    //GET PEDIDOS -- obtener todos los pedidos
    public List<Pedido> obtenerAllPedidos(){
        List<Pedido> pedidos = new ArrayList<>();
        return pedidos = pedidoRepository.findAll();
    }





}
