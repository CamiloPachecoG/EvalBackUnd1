package com.everis.prueba1.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

	public Optional<Producto> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id);
	}

	public @Valid Producto actualizarProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

}
