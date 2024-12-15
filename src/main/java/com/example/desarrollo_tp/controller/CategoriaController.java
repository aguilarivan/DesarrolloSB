package com.example.desarrollo_tp.controller;

import com.example.desarrollo_tp.model.Categoria;
import com.example.desarrollo_tp.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // POST CATEGORIA - Crear una categoria
    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.crearCategoria(categoria);
    }

    // GET CATEGORIAS - Obtener todas las categorias
    @GetMapping
    public List<Categoria> obtenerTodos() {
        return categoriaService.obtenerTodos();
    }

    // DELETE CATEGORIA - Eliminar una categoria
    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable int id) {
        categoriaService.eliminarCategoria(id);
    }

}
