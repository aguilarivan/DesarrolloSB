package com.example.desarrollo_tp.service;

import com.example.desarrollo_tp.model.Pedido;
import com.example.desarrollo_tp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Crear un nuevo pedido
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Obtener todos los pedidos
    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll();
    }

    // Obtener un pedido por su ID
    public Optional<Pedido> obtenerPedidoPorId(int id) {
        return pedidoRepository.findById(id);
    }

    // Actualizar un pedido
    public Pedido actualizarPedido(int id, Pedido pedido) {
        if (pedidoRepository.existsById(id)) {
            pedido.setId(id);
            return pedidoRepository.save(pedido);
        }
        return null;  // Retorna null si no existe el pedido
    }

    // Eliminar un pedido
    public boolean eliminarPedido(int id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;  // Retorna false si no existe el pedido
    }
}
