package com.almarone.coletaseletiva.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almarone.coletaseletiva.web.domain.Gestor;

public interface GestorRepository extends JpaRepository<Gestor, Long>{
	
	
	// Login -> email e senha
	// Methods Queries
	Optional<Gestor> findByEmail(String email);
	boolean existsByEmail(String email);
}
