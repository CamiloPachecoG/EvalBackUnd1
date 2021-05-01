package com.everis.prueba1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.prueba1.models.Usuario;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	List<Usuario> findAll();
	
}