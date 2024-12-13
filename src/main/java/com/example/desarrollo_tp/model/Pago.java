package com.example.desarrollo_tp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
public class Pago {

    @Id
    int id;
    //PagoStrategy metodoDePago;
    double monto;
    boolean pagado;
    String cbu;
    long cuit;
    String alias;
}
