package com.example.desarrollo_tp.service;

import com.example.desarrollo_tp.model.Categoria;
import com.example.desarrollo_tp.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired private CategoriaRepository categoriaRepository;

    // POST CATEGORIA - Crear una categoria
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // GET CATEGORIAS - Obtener todas las categorias
    public List<Categoria> obtenerTodos() {
        return categoriaRepository.findAll();
    }

}
