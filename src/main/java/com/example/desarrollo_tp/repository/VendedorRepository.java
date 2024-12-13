package com.example.desarrollo_tp.repository;

import com.example.desarrollo_tp.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
    // Métodos de consulta personalizados (si es necesario)
    
}
