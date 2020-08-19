package com.almarone.coletaseletiva.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almarone.coletaseletiva.web.domain.Bairro;


public interface BairroDao extends JpaRepository<Bairro, Long>{
	
}
