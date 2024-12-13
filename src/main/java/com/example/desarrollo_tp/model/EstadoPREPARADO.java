package model;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("PREPARADO")
public class EstadoPREPARADO extends Estado{

    //constructores
    public EstadoPREPARADO() {super();}

    //metodos
    public TipoEstado getEstado(){
        return TipoEstado.PREPARADO;
    }
    public Estado siguiente(){
        return new EstadoENVIADO();
    }

    @Override
    public String stringEstado() {
        return "PREPARADO";
    }
}