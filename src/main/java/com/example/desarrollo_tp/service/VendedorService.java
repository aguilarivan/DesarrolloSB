package com.example.desarrollo_tp.service;

import com.example.desarrollo_tp.model.Vendedor;
import com.example.desarrollo_tp.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;

    public Vendedor crearVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public List<Vendedor> obtenerTodos() {
        return vendedorRepository.findAll();
    }

    public Optional<Vendedor> obtenerPorId(Integer id) {
        return vendedorRepository.findById(id);
    }

    public void eliminarVendedor(Integer id){
        vendedorRepository.deleteById(id);
    }
}
