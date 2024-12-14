package com.example.desarrollo_tp.controller;

import com.example.desarrollo_tp.model.Cliente;
import com.example.desarrollo_tp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // POST CLIENTE - Crear un cliente
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }
    // GET CLIENTES - Obtener todos los clientes
    @GetMapping
    public List<Cliente> obtenerTodos() {
        return clienteService.obtenerTodos();
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public Optional<Cliente> obtenerPorId(@PathVariable Integer id) {
        return clienteService.obtenerPorId(id);
    }

    // PUT CLIENTE - Actualizar un cliente
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Integer id, @RequestBody Cliente clienteActualizado) {
        return clienteService.actualizarCliente(id, clienteActualizado);
    }

    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);
    }
}
