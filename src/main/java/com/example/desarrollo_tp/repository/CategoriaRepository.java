package com.example.desarrollo_tp.repository;

import com.example.desarrollo_tp.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Métodos de consulta personalizados (si es necesario)
}