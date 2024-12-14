// VendedoresController.java
package com.example.desarrollo_tp.controller;

import com.example.desarrollo_tp.model.Cliente;
import org.springframework.web.bind.annotation.RestController;
import com.example.desarrollo_tp.model.Vendedor;
import com.example.desarrollo_tp.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendedores")
public class VendedoresController {

    @Autowired
    private VendedorService vendedorService;

    // POST VENDEDOR - Crear un vendedor
    @PostMapping
    public Vendedor crearVendedor(@RequestBody Vendedor vendedor) {
        return vendedorService.crearVendedor(vendedor);
    }

    // GET VENDEDORES - Obtener todos los vendedores
    @GetMapping
    public List<Vendedor> obtenerTodos() {
        return vendedorService.obtenerTodos();
    }
    // PUT VENDEDOR - Actualizar un vendedor
    @PutMapping("/{id}")
    public Vendedor actualizarVendedor(@PathVariable Integer id, @RequestBody Vendedor vendedorActualizado) {
        return vendedorService.actualizarVendedor(id, vendedorActualizado);
    }
    // DELETE VENDEDOR - Eliminar un vendedor
    @DeleteMapping("/{id}")
    public void eliminarVendedor(@PathVariable Integer id){
        vendedorService.eliminarVendedor(id);
    }







}
