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
    public Optional<Producto> encontrarPorId(Long id){
        try {
            return
        } catch (Exception e) {
            
        }
    }
    
	public Producto guardarProducto (Producto producto){

    }

    public Producto actualizarProductoId(Long id, Producto producto){

    }

	public Producto actualizarProductoPrecio(double precio, Producto producto){

    }

	public Producto actualizarProductoDescripcion(String descripcion, Producto producto){

    }

    public void borrarProductoPorId(Long id){

    }
}