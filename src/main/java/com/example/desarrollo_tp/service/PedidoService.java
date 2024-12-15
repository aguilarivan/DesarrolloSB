    package com.example.desarrollo_tp.service;

    import com.example.desarrollo_tp.model.*;
    import com.example.desarrollo_tp.repository.*;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    @Service
    public class PedidoService {

        @Autowired
        private PedidoRepository pedidoRepository;

        // POST
        public Pedido crearPedido(Pedido pedido) {
            // Aquí podrías agregar lógica adicional, por ejemplo, validar los datos antes de guardar
            if (pedido.getItemsPedidos().isEmpty()) {
                throw new IllegalArgumentException("El pedido debe contener al menos un item.");
            }

            // Guardar el pedido en la base de datos
            return pedidoRepository.save(pedido);
        }

        // GET PEDIDOS - Obtener todos los pedidos
        public List<Pedido> obtenerPedidos() {
            return pedidoRepository.findAll();
        }


        // PUT - Actualizar un pedido
        public Pedido editarPedido(int id, Pedido pedido) {
            // Verifica si el pedido con el id existe
            Pedido pedidoExistente = pedidoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Pedido no encontrado con el ID: " + id));

            // Actualiza los campos del pedido existente con los nuevos valores
            pedidoExistente.setCliente(pedido.getCliente());
            pedidoExistente.setItemsPedidos(pedido.getItemsPedidos());
            pedidoExistente.setPago(pedido.getPago());
            pedidoExistente.setEstado(pedido.getEstado());
            pedidoExistente.setVendedor(pedido.getVendedor());

            // Guarda el pedido actualizado en la base de datos
            return pedidoRepository.save(pedidoExistente);
        }

        // DELETE PEDIDO - Eliminar un pedido
        public void eliminarPedido(int id) {
            pedidoRepository.deleteById(id);
        }

    }
