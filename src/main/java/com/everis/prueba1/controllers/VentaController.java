package com.everis.prueba1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.everis.prueba1.models.Venta;
import com.everis.prueba1.repositories.VentaRepository;
import com.everis.prueba1.services.VentaService;

@Controller
public class VentaController {
	
	@Autowired
	VentaService ventaService;
	@Autowired
	VentaRepository ventaRepository;
	
	@RequestMapping("/venta")
	public String index() {
		return "venta.jsp";
	}
	
	@RequestMapping("/ventaAdd")
	public String usuarios(@RequestParam(value="producto") String producto, 
			@RequestParam(value="precio") String precio,
			@RequestParam(value="cantidad") String cantidad,
			Model model) {
		
		int validaciones = 0;
		
		if(producto.length() > 0 && precio.length() > 0 && cantidad.length() > 0) {
			model.addAttribute("alerta", "Debe rellenar los campos");
			validaciones++;
		}
		
		if(validaciones == 1) {
			Venta venta = new Venta();
			venta.setProducto(producto);
			venta.setPrecio(precio);
			venta.setCantidad(cantidad);
			
			venta = ventaService.guardarVenta(venta);
			
						
			model.addAttribute("producto", producto);
			model.addAttribute("precio", precio);
			model.addAttribute("cantidad", cantidad);
			
			
			return "redirect:listaVentas";	
		}else {
			return "venta.jsp";
		}
				
		
	}
	
	@RequestMapping("/listaVentas")
	public ModelAndView listaVentas(){
		
		List<Venta> listaVentas = ventaService.AllVentas();
		
		return new ModelAndView("listaVenta.jsp","listaVentas", listaVentas);
	}
	
	@RequestMapping("/venta/{id}")
	public ModelAndView eliminarVenta(@PathVariable("id") Long id){
		ventaRepository.deleteById(id);
		return new ModelAndView("redirect:/listaVentas"); 
	}
}
