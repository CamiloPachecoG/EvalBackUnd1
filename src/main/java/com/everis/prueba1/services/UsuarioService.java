package com.everis.prueba1.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.prueba1.models.Usuario;
import com.everis.prueba1.repositories.UsuarioRepository;



@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> AllUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> buscarPorId(Long id){
		return usuarioRepository.findById(id);
	}
	
	public Usuario actualizarUsuario(@Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
}
