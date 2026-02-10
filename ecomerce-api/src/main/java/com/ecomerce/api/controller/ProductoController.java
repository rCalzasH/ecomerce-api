package com.ecomerce.api.controller;

import com.ecomerce.api.model.Producto;
import com.ecomerce.api.service.ProductoService;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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

    public List<Producto> todosLosProductos(){
        return p.todosLosProductos();
    }
    
    public ResponseEntity<Producto> encontrarPorId(@RequestParam Long id){
        return p.encontrarPorId(id).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
	public ResponseEntity<Producto> guardarProducto (@RequestBody Producto producto){
        return p.guardarProducto(producto).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }
    @PatchMapping("/id")
    public ResponseEntity<Producto> actualizarProductoId(@RequestParam Long id, @RequestBody Producto producto){
        return p.actualizarProductoId(id, producto).map(ResponseEntity :: ok  ).orElse(ResponseEntity.notFound().build());
    }
    @PatchMapping("/precio")
	public ResponseEntity<Producto> actualizarProductoPrecio(@RequestParam double precio, @RequestBody Producto producto){
        return p.actualizarProductoPrecio(precio, producto).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }
    @PatchMapping("/descripcion")
	public ResponseEntity<Producto> actualizarProductoDescripcion(@RequestParam String descripcion,@RequestBody Producto producto){
        return p.actualizarProductoDescripcion(descripcion, producto).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping
    public void borrarProductoPorId(@RequestParam Long id){
        p.borrarProductoPorId(id);
    }
}