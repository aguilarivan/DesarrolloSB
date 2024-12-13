package com.example.desarrollo_tp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Categoria {

    @Id
    private int id;
    private String descripcion;
    private Class<? extends ItemMenu> tipoItem;

}
