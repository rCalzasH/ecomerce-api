/*
*rCalzasH
*clase que implementa la interfaz de ProductoService
 */
package com.ecomerce.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.ecomerce.api.model.Producto;

public class ProductoServiceImpl implements ProductoService {
    private AtomicLong idCont = new AtomicLong(1);
    private List<Producto> productos = new ArrayList<>();
    
    public List<Producto> todosLosProductos(){
        return productos;
    }
	
	public Optional<Producto> encontrarPorId(Long id){
        return productos.stream().filter(producto->producto.getId().equals(id)).findFirst();
    }
    
	public Producto guardarProducto (Producto producto){
        producto.setId(idCont.getAndIncrement());
        productos.add(producto);
        return producto;

    }

    
    public Producto actualizarProductoId(Long id, Producto producto){
        Producto prod = productos.stream().filter(pro->pro.equals(producto)).findFirst().get();
        return prod.setId(id);
        }
    
    public Producto actualizarProductoPrecio(double precio, Producto producto){
        Producto prod = productos.stream().filter(pro->pro.equals(producto)).findFirst().get();
        return prod.setPrecio(precio); 
        }
    
    public Producto actualizarProductoDescripcion(String descripcion, Producto producto){
        Producto prod = productos.stream().filter(pro->pro.equals(producto)).findFirst().get();
        return prod.setDescripcion(descripcion);
        }

    public void borrarProductoPorId(Long id){
        Producto p = productos.stream().filter(prod->prod.getId().equals(id)).findFirst().get();
        productos.remove(p);
    }
}