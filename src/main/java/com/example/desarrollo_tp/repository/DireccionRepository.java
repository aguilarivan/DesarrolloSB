package com.example.desarrollo_tp.repository;

import com.example.desarrollo_tp.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
    // Métodos de consulta personalizados (si es necesario)
}
