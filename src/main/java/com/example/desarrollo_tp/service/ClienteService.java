package com.example.desarrollo_tp.service;

import com.example.desarrollo_tp.model.Cliente;
import com.example.desarrollo_tp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // POST CLIENTE - Crear un cliente
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    // GET CLIENTES - Obtener todos los clientes
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }
    // Obtener un cliente por ID
    public Optional<Cliente> obtenerPorId(Integer id) {
        return clienteRepository.findById(id);
    }

    // Actualizar un cliente
    public Cliente actualizarCliente(Integer id, Cliente clienteActualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                 //   cliente.setNombre(clienteActualizado.getNombre());
               //     cliente.setCuit(clienteActualizado.getCuit());
               //     cliente.setEmail(clienteActualizado.getEmail());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    // Eliminar un cliente
    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
