package com.example.desarrollo_tp.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("RECIBIDO")
public class EstadoRECIBIDO extends Estado {

    // Constructores -----------------------------------------------------------------------------------------------------------------------------------
    public EstadoRECIBIDO() {super();}

    // Methods -----------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public TipoEstado getEstado(){
        return TipoEstado.RECIBIDO;
    }
    @Override
    public Estado siguiente(){
        return new EstadoACEPTADO();
    }
    @Override
    public String stringEstado() {
        return "RECIBIDO";
    }
}