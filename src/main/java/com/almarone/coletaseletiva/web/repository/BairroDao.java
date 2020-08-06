package com.almarone.coletaseletiva.web.repository;

import java.util.List;

import com.almarone.coletaseletiva.web.domain.Bairro;


public interface BairroDao {
	
	Bairro save(Bairro bairro);
	void update(Bairro bairro);
	void delete(Long id);
	Bairro findById(Long id);
	List<Bairro> findAll();

}
