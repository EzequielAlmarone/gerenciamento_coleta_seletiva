package com.almarone.coletaseletiva.web.services;

import java.util.List;

import com.almarone.coletaseletiva.web.domain.Bairro;


public interface BairroService {
	void save(Bairro bairro);
	void update(Bairro bairro);
	void delete(Long id);
	Bairro findById(Long id);
	List<Bairro> findAll();
	
	
	// Regras de Negocio
	
	void bairroDuplicado(String nomeBairro);
	
}
