package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almarone.coletaseletiva.api.dto.BairroDTO;
import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.repository.BairroDao;


@Service @Transactional(readOnly = false)
public class BairroServiceImpl implements BairroService {
	@Autowired
	private BairroDao repository;

	@Override
	public Bairro save(Bairro bairro) {
		return repository.save(bairro);
			
	}

	@Override
	public Bairro update(Bairro bairro) {
		return repository.save(bairro);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override @Transactional(readOnly = true)
	public Optional<BairroDTO> findById(Long id) {
		return repository.findById(id).map(BairroDTO::create);
	}

	@Override @Transactional(readOnly = true)
	public List<BairroDTO> findAll() {
		return repository.findAll().stream().map(BairroDTO::create).collect(Collectors.toList());
	}
		
	
}