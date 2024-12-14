package com.example.desarrollo_tp.model;

import jakarta.persistence.*;

@Entity
public class Cliente implements EventListener {
    // Atributos --------------------------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private long cuit;
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "coordenadas_id")
    private Coordenada coordenadas;

    // Constructor ------------------------------------------------------------------------------------------------------------------------------------
    public Cliente(){};
    public Cliente(String nombre, long cuit, String email, Direccion direccion, Coordenada coordenadas) {
        setNombre(nombre);
        setCuit(cuit);
        setEmail(email);
        setDireccion(direccion);
        setCoordenadas(coordenadas);
    }

    // Getters -----------------------------------------------------------------------------------------------------------------------------------------
    public Integer getId() {return id;}
    public String getNombre() {return nombre;}
    public long getCuit() {return cuit;}
    public String getEmail() {return email;}
    public Direccion getDireccion() {return direccion;}
    public Coordenada getCoordenadas() {return coordenadas;}

    // Setters -----------------------------------------------------------------------------------------------------------------------------------------
    private void setNombre(String nombre) {this.nombre = nombre;}
    private void setCuit(long cuit) {this.cuit = cuit;}
    private void setEmail(String email) {this.email = email;}
    private void setDireccion(Direccion direccion) {this.direccion = direccion;}
    private void setCoordenadas(Coordenada coordenadas) {this.coordenadas = coordenadas;}

    //  Methods -----------------------------------------------------------------------------------------------------------------------------------------
    public boolean nombreIgual(String nombre) {return this.getNombre().equalsIgnoreCase(nombre);}
    public boolean cuitIgual(long cuit) {return this.getCuit() == cuit;}
    public boolean idIgual(int id) {return this.getId() == id;}
    public void modificarAtributos(String nombre, long cuit, String email, Direccion direccion, Coordenada coordenadas) {
        if (nombre != null && !nombre.isEmpty()) {setNombre(nombre);}
        if (cuit != -1) {setCuit(cuit);}
        if (email != null && !email.isEmpty()) {setEmail(email);}
        if (direccion != null) {setDireccion(direccion);}
        if (coordenadas != null) {setCoordenadas(coordenadas);}
    }
    public void modificarCliente(Cliente cliente) {
        if (cliente != null) {
            setNombre(cliente.getNombre());
            setCuit(cliente.getCuit());
            setEmail(cliente.getEmail());
            setDireccion(cliente.getDireccion());
            setCoordenadas(cliente.getCoordenadas());
        }
    }

   @Override
    public void update(Pedido p) {
        if(p.getEstado().equals(TipoEstado.ENVIADO)){
//            JOptionPane.showMessageDialog(null, "El pedido se ha actualizado.\n Estado del Pedido:" + p.getEstado().stringEstado() + "\nPago generado");
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "El pedido se ha actualizado.\n Estado del Pedido:" + p.getEstado().stringEstado());
       }
   }


}