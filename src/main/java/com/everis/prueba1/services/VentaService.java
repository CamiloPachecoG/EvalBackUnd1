package com.everis.prueba1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.everis.prueba1.models.Venta;
import com.everis.prueba1.repositories.VentaRepository;

@Service
public class VentaService {
	@Autowired
	VentaRepository ventaRepository;
	
	public Venta guardarVenta(Venta venta) {
		return ventaRepository.save(venta);
	}
	
	public List<Venta> AllVentas(){
		return ventaRepository.findAll();
	}
	
	public Optional<Venta> buscarPorId(Long id){
		return ventaRepository.findById(id);
	}
}
