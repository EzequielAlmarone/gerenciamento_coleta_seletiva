package com.almarone.coletaseletiva.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almarone.coletaseletiva.web.domain.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	
	// Login -> email e senha
	// Methods Queries
	Optional<Usuario> findByEmail(String email);
	boolean existsByEmail(String email);
}
