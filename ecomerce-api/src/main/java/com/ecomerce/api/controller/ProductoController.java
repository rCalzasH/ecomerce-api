package com.ecomerce.api.controller;

import com.ecomerce.api.model.Producto;
import com.ecomerce.api.service.ProductoService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/productos")

public class ProductoController {
    private final ProductoService p;
    //inyectamos dependencias en el controller 
    public ProductoController(ProductoService p ){
        this.p=p;
    }
    public Optional<Producto> encontrarPorId(@RequestParam Long id){
        return p.encontrarPorId(id);
    }
    @PostMapping
	public Producto guardarProducto (@RequestBody Producto producto){
        
    }
    @PatchMapping("/id")
    public Producto actualizarProductoId(@RequestParam Long id, @RequestBody Producto producto){

    }
    @PatchMapping("/precio")
	public Producto actualizarProductoPrecio(@RequestParam double precio, @RequestBody Producto producto){

    }
    @PatchMapping("/descripcion")
	public Producto actualizarProductoDescripcion(@RequestParam String descripcion,@RequestBody Producto producto){

    }
    @DeleteMapping
    public void borrarProductoPorId(@RequestParam Long id){

    }
}