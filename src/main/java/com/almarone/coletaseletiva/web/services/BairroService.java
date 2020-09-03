package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;

import com.almarone.coletaseletiva.api.dto.BairroDTO;
import com.almarone.coletaseletiva.web.domain.Bairro;


public interface BairroService{
	Bairro save(Bairro bairro);
	Bairro update(Bairro bairro);
	void delete(Long id);
	Optional<BairroDTO> findById(Long id);
	List<BairroDTO> findAll();
	
	
	// Regras de Negocio
	
	//void bairroDuplicado(String nomeBairro);
	
}
