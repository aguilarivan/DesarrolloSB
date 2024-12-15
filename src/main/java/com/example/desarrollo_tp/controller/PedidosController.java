package com.example.desarrollo_tp.controller;

import com.example.desarrollo_tp.model.Pedido;
import com.example.desarrollo_tp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidoService pedidoService;

    // POST PEDIDO - Crear un pedido
    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        try {
            Pedido nuevoPedido = pedidoService.crearPedido(pedido);
            return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);  // Devuelve el nuevo pedido creado
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);  // Si hay error, devuelve 400
        }
    }

    // GET PEDIDOS - Obtener todos los pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerPedidos() {
        List<Pedido> pedidos = pedidoService.obtenerPedidos();
        return ResponseEntity.ok(pedidos); // Devolver la lista de pedidos
    }

    // DELETE PEDIDO - Eliminar un pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable int id) {
        pedidoService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }


}
