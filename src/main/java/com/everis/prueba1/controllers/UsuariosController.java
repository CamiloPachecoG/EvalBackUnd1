package com.everis.prueba1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.everis.prueba1.models.Usuario;
import com.everis.prueba1.repositories.UsuarioRepository;
import com.everis.prueba1.services.UsuarioService;

@Controller
public class UsuariosController {
	
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping("/usuario")
	public String index(Model model) {
		
		model.addAttribute("alerta", "");
		
		return "usuario.jsp";
	}
	
	@RequestMapping("/usuarioAdd")
	public String usuarios(@RequestParam(value="nombre") String nombre, 
			@RequestParam(value="apellido") String apellido,
			@RequestParam(value="edad") String edad,
			Model model) {
		
			int validaciones = 0;
			
			if(nombre.length() > 0 && apellido.length() > 0 && edad.length() > 0) {
				model.addAttribute("alerta", "Debe rellenar los campos");
				validaciones++;
			}
			
			if(validaciones == 1) {
				
				Usuario usuario = new Usuario();
				usuario.setNombre(nombre);
				usuario.setApellido(apellido);
				usuario.setEdad(edad);
				
				usuario = usuarioService.guardarUsuario(usuario);
				
				model.addAttribute("nombre", nombre);
				model.addAttribute("apellido", apellido);
				model.addAttribute("edad", edad);
				
				
				return "redirect:listaUsuarios";		
			}else {
				
				return "usuario.jsp";
			}
			
	}
	
	@RequestMapping("/listaUsuarios")
	public ModelAndView listaUsuarios(){
		
		List<Usuario> listaUsuarios = usuarioService.AllUsuarios();
		
		return new ModelAndView("listaUsuario.jsp","listaUsuarios", listaUsuarios);
	}
	
	@RequestMapping("/editUsuario/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Usuario> usuario = usuarioService.buscarPorId(id);
		model.addAttribute("usuario", usuario);
		return "usuario.jsp";
	}
	
	/*
	@RequestMapping("/usuarioEdit")
	public ModelAndView usuarioEdit(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.guardarUsuario(usuario);
		return new ModelAndView("redirect:/listaUsuarios"); 
	}
	*/
	

	
	@RequestMapping("/usuario/{id}")
	public ModelAndView eliminarUsuario(@PathVariable("id") Long id){
		usuarioRepository.deleteById(id);
		return new ModelAndView("redirect:/listaUsuarios"); 
	}
	
	

}
