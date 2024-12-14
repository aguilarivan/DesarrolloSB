package com.example.desarrollo_tp.model;

import jakarta.persistence.*;

@Entity
public class Pago {
    // Atributos ------------------------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@OneToOne
    //@JoinColumn(name = "metodoDePago_id")
    // private PagoStrategy metodoDePago;
    private double monto;
    private boolean pagado;
    private String cbu;
    private long cuit;
    private String alias;

    // Constructor ------------------------------------------------------------------------------------------------------------------------------------
    public Pago(){};
    public Pago(PagoStrategy m, double precioBase, boolean pagado, String cbu, long cuit, String alias ) {
        //setMetodoPago(m);
        setMonto(m.precio(precioBase));
        setPagado(pagado);
        setCbu(cbu);
        setCuit(cuit);
        setAlias(alias);
    }

    // Getters -----------------------------------------------------------------------------------------------------------------------------------------
//    public PagoStrategy getMetodoDePago(){
        //return this.metodoDePago;

  //  }
    public double getMonto(){
        return this.monto;
    }
    public int getId(){
        return this.id;
    }
    public String getCbu(){return this.cbu;}
    public long getCuit(){return this.cuit;}
    public String getAlias(){return this.alias;}
    public boolean isPagado(){return this.pagado;}

    // Setters -------------------------------------------------------------------------------------------------------------------------------------------
 //   public void setMetodoPago(PagoStrategy m){
  //      metodoDePago = m;
  //  }
    public void setMonto(double precio){
        this.monto  = precio;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setCbu(String cbu){
        this.cbu = cbu;
    }
    public void setCuit(long cuit){
        this.cuit = cuit;
    }
    public void setAlias(String alias){
        this.alias = alias;
    }
    public void setPagado(boolean pagado){
        this.pagado = pagado;
    }

    // Métodos --------------------------------------------------------------------------------------------------------------------------------------------
   // public void pagar(){
      //  metodoDePago.obtenerInformacion(this);
 //   }

}
