package com.example.desarrollo_tp.model;


public interface PagoStrategy {

    public MediosDePagos getMedioDePago();
    public double precio(double precio);
    public void obtenerInformacion(Pago pago);

}
