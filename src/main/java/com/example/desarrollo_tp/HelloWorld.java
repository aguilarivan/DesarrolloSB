package com.example.desarrollo_tp;
import com.example.desarrollo_tp.model.Bebida;
import com.example.desarrollo_tp.model.Categoria;
import com.example.desarrollo_tp.model.ItemMenu;
import com.example.desarrollo_tp.model.Vendedor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String helloWorld() {
        Categoria categoria = new Categoria(); // Initialize categoria properly
        Vendedor vendedor = new Vendedor(); // Initialize vendedor properly
        ItemMenu item = new Bebida("Coca Cola", "Bebida gaseosa", 1.5, true, false, categoria, vendedor, 0.0, 500);
        String bebida = "sn";
        return bebida;
    }
}
