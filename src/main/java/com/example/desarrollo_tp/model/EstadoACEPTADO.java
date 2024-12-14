package com.example.desarrollo_tp.model;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ACEPTADO")
public class EstadoACEPTADO extends Estado{

    // Constructores ------------------------------------------------------------------------------------------------------------------------------------
    public EstadoACEPTADO() {super();}

    // Methods ------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public Estado siguiente() {
        return new EstadoPREPARADO();
    }
    @Override
    public TipoEstado getEstado() {
        return TipoEstado.ACEPTADO;
    }
    @Override
    public String stringEstado() {
        return "ACEPTADO";
    }
}