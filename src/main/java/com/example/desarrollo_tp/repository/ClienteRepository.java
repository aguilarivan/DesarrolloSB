package com.example.desarrollo_tp.repository;

import com.example.desarrollo_tp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Métodos de consulta personalizados (si es necesario)
}
