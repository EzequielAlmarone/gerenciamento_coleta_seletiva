package com.almarone.coletaseletiva.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.services.BairroService;


@Repository
public class BairroDaoImpl extends AbstractDao<Bairro, Long> implements BairroDao {
	@Autowired
	private BairroService service;
	@Override
	
	public Bairro findByNome(String nome) {
		return null;
	}

	
}
