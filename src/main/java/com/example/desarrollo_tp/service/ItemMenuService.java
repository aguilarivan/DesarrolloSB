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

    // DELETE ITEM MENU - Eliminar un item de menú
    public void eliminarItemMenu(int id) {
        itemMenuRepository.deleteById(id);
    }

    // PUT PLATO - Actualizar un plato
    public Plato editarPlato(int id, Plato plato) {
        // Verifica si el plato con el id existe
        Plato platoExistente = platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado con el ID: " + id));
        // Obtener y establecer la entidad completa de Categoria
        Categoria categoria = categoriaRepository.findById(plato.getCategoria().getId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        platoExistente.setCategoria(categoria);

        // Obtener y establecer la entidad completa de Vendedor
        Vendedor vendedor = vendedorRepository.findById(plato.getVendedor().getId())
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
        platoExistente.setVendedor(vendedor);
        // Actualiza los campos del plato existente con los nuevos valores
        platoExistente.setNombre(plato.getNombre());
        platoExistente.setDescripcion(plato.getDescripcion());
        platoExistente.setPrecio(plato.getPrecio());
        platoExistente.setAptoVegano(plato.isAptoVegano());
        platoExistente.setAptoCeliaco(plato.isAptoCeliaco());
        platoExistente.setCalorias(plato.getCalorias());
        platoExistente.setPeso(plato.getPeso());
        // Guarda el plato actualizado en la base de datos
        return platoRepository.save(platoExistente);
    }

    // PUT BEBIDA - Actualizar una bebida
    public Bebida editarBebida(int id, Bebida bebida) {
        // Verifica si la bebida con el id existe
        Bebida bebidaExistente = bebidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bebida no encontrada con el ID: " + id));
        // Obtener y establecer la entidad completa de Categoria
        Categoria categoria = categoriaRepository.findById(bebida.getCategoria().getId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        bebidaExistente.setCategoria(categoria);
        // Actualiza los campos del plato existente con los nuevos valores
        bebidaExistente.setNombre(bebida.getNombre());
        bebidaExistente.setDescripcion(bebida.getDescripcion());
        bebidaExistente.setPrecio(bebida.getPrecio());
        bebidaExistente.setAptoVegano(bebida.isAptoVegano());
        bebidaExistente.setAptoCeliaco(bebida.isAptoCeliaco());
        bebidaExistente.setTamanio(bebida.getTamanio());
        bebidaExistente.setGraduacionAlcoholica(bebida.getGraduacionAlcoholica());
        // Guarda la bebida actualizada en la base de datos
        return bebidaRepository.save(bebidaExistente);
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
