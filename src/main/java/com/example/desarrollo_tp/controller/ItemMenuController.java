package com.example.desarrollo_tp.controller;

import com.example.desarrollo_tp.model.Bebida;
import com.example.desarrollo_tp.model.Categoria;
import com.example.desarrollo_tp.model.ItemMenu;
import com.example.desarrollo_tp.model.Plato;
import com.example.desarrollo_tp.service.ItemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/item-menu")
public class ItemMenuController {

    @Autowired
    private ItemMenuService itemMenuService;

    // GET ITEM MENU - Obtener todos los items del menú
    @GetMapping
    public ResponseEntity<List<ItemMenu>> obtenerItemsMenu() {
        List<ItemMenu> itemsMenu = itemMenuService.obtenerItemsMenu();
        return ResponseEntity.ok(itemsMenu); // Devolver la lista de items
    }

    // POST PLATO - Crear un plato
    @PostMapping("/plato")
    public ResponseEntity<Plato> crearPlato(@RequestBody Plato plato) {
        Plato nuevoPlato = itemMenuService.crearPlato(plato);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPlato);
    }
    // POST BEBIDA - Crear una bebida
    @PostMapping("/bebida")
    public ResponseEntity<Bebida> crearBebida(@RequestBody Bebida bebida) {
        Bebida nuevaBebida = itemMenuService.crearBebida(bebida);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaBebida);
    }

}

