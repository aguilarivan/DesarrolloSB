package com.example.desarrollo_tp.model;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ENVIADO")
public class EstadoENVIADO extends Estado {

    // Constructores ------------------------------------------------------------------------------------------------------------------------------------
    public EstadoENVIADO() {
        super();
    }

    // Methods -----------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public TipoEstado getEstado() {
        return TipoEstado.ENVIADO;
    }
    @Override
    public Estado siguiente() {
        return this;
    }
    @Override
    public String stringEstado() {
        return "ENVIADO";
    }
}