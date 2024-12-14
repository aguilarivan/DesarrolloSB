package com.example.desarrollo_tp.model;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "estado_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Estado {
    // Atributos -------------------------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Constructores ----------------------------------------------------------------------------------------------------------------------------------
    public Estado(){};

    // Methods ----------------------------------------------------------------------------------------------------------------------------------------
    public abstract TipoEstado getEstado();
    public abstract Estado siguiente();
    public abstract String stringEstado();

}