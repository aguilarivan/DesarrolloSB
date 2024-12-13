package com.example.desarrollo_tp.model;

import jakarta.persistence.*;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    //PagoStrategy metodoDePago;
    double monto;
    boolean pagado;
    String cbu;
    long cuit;
    String alias;
}
