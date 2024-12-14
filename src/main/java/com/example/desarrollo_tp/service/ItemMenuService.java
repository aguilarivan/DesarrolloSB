package com.example.desarrollo_tp.service;

import com.example.desarrollo_tp.model.*;
import com.example.desarrollo_tp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemMenuService {

    @Autowired
    private PlatoRepository platoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private BebidaRepository bebidaRepository;
    @Autowired
    private VendedorRepository vendedorRepository;
    @Autowired
    private ItemMenuRepository itemMenuRepository;

    // GET ITEM MENU - Obtener todos los items de menú
    public List<ItemMenu> obtenerItemsMenu() {
        return itemMenuRepository.findAll();
    }



    public Plato crearPlato(Plato plato) {
        int categoriaId = plato.getCategoria().getId(); // Se obtiene el ID de la categoría desde el objeto recibido
        Categoria categoria = categoriaRepository.findById(categoriaId) // Buscar la categoría por su ID
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        int vendedorId = plato.getVendedor().getId(); // Se obtiene el ID del vendedor desde el objeto recibido
        Vendedor vendedor = vendedorRepository.findById(vendedorId) // Buscar el vendedor por su ID
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));

        plato.setVendedor(vendedor); // Asignar el vendedor al plato
        plato.setCategoria(categoria); // Asignar la categoría al plato
        return platoRepository.save(plato); // Guardar el plato con la categoría asignada
    }

    public Bebida crearBebida(Bebida bebida) {
        int categoriaId = bebida.getCategoria().getId(); // Se obtiene el ID de la categoría desde el objeto recibido
        Categoria categoria = categoriaRepository.findById(categoriaId) // Buscar la categoría por su ID
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        int vendedorId = bebida.getVendedor().getId(); // Se obtiene el ID del vendedor desde el objeto recibido
        Vendedor vendedor = vendedorRepository.findById(vendedorId) // Buscar el vendedor por su ID
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
        bebida.setVendedor(vendedor); // Asignar el vendedor a la bebida
        bebida.setCategoria(categoria); // Asignar la categoría a la bebida
        return bebidaRepository.save(bebida); // Guardar la bebida con la categoría asignada
    }
}
