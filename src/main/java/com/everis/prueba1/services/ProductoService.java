package com.everis.prueba1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.prueba1.models.Producto;
import com.everis.prueba1.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	public Producto guardarProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public List<Producto> allProductos(){
		return productoRepository.findAll();
	}

}
