package com.example.desarrollo_tp.repository;

import com.example.desarrollo_tp.model.Coordenada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordenadaRepository extends JpaRepository<Coordenada, Integer> {
    // Métodos de consulta personalizados (si es necesario)
}

