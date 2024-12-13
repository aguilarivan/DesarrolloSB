package model;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "estado_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //constructores
    public Estado(){super();}

    //metodos
    public abstract TipoEstado getEstado();
    public abstract Estado siguiente();
    public abstract String stringEstado();

}