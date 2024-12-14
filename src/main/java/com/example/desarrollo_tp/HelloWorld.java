package com.example.desarrollo_tp;
import com.example.desarrollo_tp.model.*;
import jakarta.persistence.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public Cliente helloWorld() {
        Cliente cliente = new Cliente("Juan", 12345678, "email@email.com", new Direccion(), new Coordenada());
        return cliente;
    }


    @GetMapping("/hello2")
    public Plato helloWorld2() {
         // public Plato(String nombre, String descripcion, double precio, boolean aptoVegano, boolean aptoCeliaco, Categoria categoria, Vendedor vendedor, double calorias, double peso) {
        Plato plato = new Plato("nombre", "descripcion", 100, true, true, new Categoria(), new Vendedor(), 100, 100);
        return plato;
    }

    @GetMapping("/hello3")
    public Categoria helloWorld3() {
        Categoria categoria = new Categoria( "descripcion", "BEBIDA");
        Categoria categoria2 = new Categoria( "descrasddipcion", "BEBIDA");

        return categoria2;
    }

    @GetMapping("/hello4")
    public Vendedor helloWorld4() {
        Vendedor vendedor = new Vendedor("nombre", new Direccion(), new Coordenada());
        return vendedor;
    }

}
