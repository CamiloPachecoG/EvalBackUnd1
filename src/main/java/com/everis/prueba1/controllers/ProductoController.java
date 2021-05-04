package com.everis.prueba1.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.everis.prueba1.models.Producto;
import com.everis.prueba1.repositories.ProductoRepository;
import com.everis.prueba1.services.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	@Autowired
	ProductoRepository productoRepository;
	
	@RequestMapping("/producto")
	public String index(Model model) {
		model.addAttribute("alerta", "");
		return "producto.jsp";
	}
	
	@RequestMapping("/productoAdd")
	public String productos(@RequestParam(value="nombre") String nombre, 
			@RequestParam(value="precio") String precio,
			@RequestParam(value="descripcion") String descripcion,
			Model model) {
		
		int validaciones = 0;
		
		if(nombre.length() > 0 && precio.length() > 0 && descripcion.length() > 0) {
			model.addAttribute("alerta", "Debe rellenar los campos");
			validaciones++;
		}
		
		if(validaciones == 1) {
			Producto producto = new Producto();
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			producto.setDescripcion(descripcion);
			
			producto = productoService.guardarProducto(producto);
			
			System.out.println(producto.getId());
			
			model.addAttribute("nombre", nombre);
			model.addAttribute("precio", precio);
			model.addAttribute("descripcion", descripcion);
			
			return "redirect:listaProductos";
		}else {
			return "producto.jsp";
		}
		
	}
	
	@RequestMapping("/listaProductos")
	public ModelAndView listaProductos() {
		List<Producto> listaProductos = productoService.allProductos();
		
		return new ModelAndView("listaProducto.jsp", "listaProductos", listaProductos);
	}
	
	@RequestMapping("/editProducto/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Producto> producto = productoService.buscarPorId(id);
		model.addAttribute("producto", producto);
		return "editProducto.jsp";
	}
	
	@RequestMapping("/productoEdit")
	public String productoEdit(@Valid @ModelAttribute("producto") Producto producto) {
		producto = productoService.actualizarProducto(producto);
		return "redirect:/listaProductos";
	}
	
	@RequestMapping("/producto/{id}")
	public ModelAndView eliminarUsuario(@PathVariable("id") Long id){
		productoRepository.deleteById(id);
		return new ModelAndView("redirect:/listaProductos"); 
	}
}
