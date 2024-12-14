package com.example.desarrollo_tp.model;

import jakarta.persistence.*;

@Entity
public class Categoria {
    // Atributos --------------------------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private String tipoItem;

    // Constructor ------------------------------------------------------------------------------------------------------------------------------------
    public Categoria(){}
    public Categoria(String descripcion, String tipoItem){
        setDescripcion(descripcion);
        setTipoItem(tipoItem);
    }

    // Getters -----------------------------------------------------------------------------------------------------------------------------------------
    public int getId() {return id;}
    public String getDescripcion() {return descripcion;}
    public String getTipoItem() {return tipoItem;}

    // Setters -----------------------------------------------------------------------------------------------------------------------------------------
    private void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    private void setTipoItem(String tipoItem) {this.tipoItem = tipoItem;}

}
