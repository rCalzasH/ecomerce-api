package com.ecomerce.api.service;

import java.util.List;
import java.util.Optional;

import com.ecomerce.api.model.Producto;

public interface ProductoService{
	public List<Producto> todosLosProductos();
	
	public Optional <Producto> encontrarPorId(Long id);
    
	public Optional <Producto> guardarProducto (Producto producto);

    public Optional <Producto> actualizarProductoId(Long id, Producto producto);

	public Optional <Producto> actualizarProductoPrecio(double precio, Producto producto);

	public Optional <Producto> actualizarProductoDescripcion(String descripcion, Producto producto);

    public void borrarProductoPorId(Long id);
} 
