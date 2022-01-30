package com.blogJess.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogJess.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByUsuario(String usuario);
	
}


