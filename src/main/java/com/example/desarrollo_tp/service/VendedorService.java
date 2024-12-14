package com.example.desarrollo_tp.service;

import com.example.desarrollo_tp.model.Coordenada;
import com.example.desarrollo_tp.model.Vendedor;
import com.example.desarrollo_tp.repository.CoordenadaRepository;
import com.example.desarrollo_tp.repository.DireccionRepository;
import com.example.desarrollo_tp.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    // POST VENDEDOR - Crear un vendedor
    public Vendedor crearVendedor(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
        return vendedor;
    }
    // GET VENDEDORES - Obtener todos los vendedores
    public List<Vendedor> obtenerTodos() {
        return vendedorRepository.findAll();
    }
    public void eliminarVendedor(int id){
        vendedorRepository.deleteById(id);
    }

    // EDITAR VENDEDOR - Actualizar un vendedor
    public Vendedor actualizarVendedor(int id, Vendedor vendedorActualizado){
        return vendedorRepository.findById(id)
                .map(vendedor -> {
                    vendedor.modificarVendedor(vendedorActualizado.getNombre(), vendedorActualizado.getDireccion(), vendedorActualizado.getCoordenadas());
                    return vendedorRepository.save(vendedor);
                })
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
    }

}
