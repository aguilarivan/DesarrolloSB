package com.example.desarrollo_tp.model;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("PREPARADO")
public class EstadoPREPARADO extends Estado{

    // Constructores ------------------------------------------------------------------------------------------------------------------------------------

    public EstadoPREPARADO() {super();}

    // Methods -----------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public TipoEstado getEstado(){
        return TipoEstado.PREPARADO;
    }
    @Override
    public Estado siguiente(){
        return new EstadoENVIADO();
    }
    @Override
    public String stringEstado() {
        return "PREPARADO";
    }
}