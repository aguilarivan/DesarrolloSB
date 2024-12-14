package com.example.desarrollo_tp.controller;

import com.example.desarrollo_tp.model.Pedido;
import com.example.desarrollo_tp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidosController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Crear un nuevo pedido
    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.crearPedido(pedido);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    // Obtener todos los pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerPedidos() {
        List<Pedido> pedidos = pedidoService.obtenerPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    // Obtener un pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable int id) {
        Optional<Pedido> pedido = pedidoService.obtenerPedidoPorId(id);
        return pedido.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar un pedido
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable int id, @RequestBody Pedido pedido) {
        Pedido pedidoActualizado = pedidoService.actualizarPedido(id, pedido);
        return pedidoActualizado != null ?
                new ResponseEntity<>(pedidoActualizado, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar un pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable int id) {
        boolean eliminado = pedidoService.eliminarPedido(id);
        return eliminado ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
