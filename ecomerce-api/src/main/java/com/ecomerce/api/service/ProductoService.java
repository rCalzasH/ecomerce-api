package com.ecomerce.api.service;
import com.ecomerce.api.model.*;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class ProductoService {
	private final List<Producto> productos = new ArrayList<>();
	//contador para poder generar ids "aletorios";
	private AtomicLong contadorId = new AtomicLong(1);
	public Producto crearProducto(Producto p){
		p.setId(contadorId.getAndIncrement());
		productos.add(p);
		return p;
	}
	public Producto eliminarProducto(Producto p){
		productos.remove(p);
	}
	

}
