package com.almarone.coletaseletiva.web.repository;

import java.util.List;
import java.util.Optional;

import com.almarone.coletaseletiva.web.domain.Bairro;


public interface BairroDao {
	
	Bairro save(Bairro bairro);
	void update(Bairro bairro);
	void delete(Long id);
	Bairro findById(Long id);
	Optional<Bairro> findByNome(String nome);
	List<Bairro> findAll();

}
