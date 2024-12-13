package com.example.desarrollo_tp.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.desarrollo_tp.model.Vendedor;
import com.example.desarrollo_tp.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VendedoresController {
    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public Vendedor crearVendedor(@RequestBody Vendedor vendedor) {
        return vendedorService.crearVendedor(vendedor);
    }

}
