package com.ecomerce.api.service;

import java.util.List;
import java.util.Optional;

import com.ecomerce.api.model.Producto;

public interface ProductoService{
	public List<Producto> todosLosProductos();
	
	public Optional<Producto> encontrarPorId(Long id);
    
	public Producto guardarProducto (Producto producto);

    public Producto actualizarProductoId(Long id, Producto producto);

	public Producto actualizarProductoPrecio(double precio, Producto producto);

	public Producto actualizarProductoDescripcion(String descripcion, Producto producto);

    public void borrarProductoPorId(Long id);
} 
