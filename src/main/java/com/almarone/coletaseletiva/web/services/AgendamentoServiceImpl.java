package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almarone.coletaseletiva.api.dto.AgendamentoDTO;
import com.almarone.coletaseletiva.web.domain.Agendamento;
import com.almarone.coletaseletiva.web.repository.AgendamentoDao;


@Service @Transactional(readOnly = false)
public class AgendamentoServiceImpl implements AgendamentoService {
	@Autowired
	private AgendamentoDao repository;

	@Override
	public Agendamento save(Agendamento agendamento) {
		return repository.save(agendamento);
		
	}

	@Override
	public Agendamento update(Agendamento agendamento) {
		return repository.save(agendamento);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}

	@Override @Transactional(readOnly = true)
	public Optional<AgendamentoDTO> findById(Long id) {
		return repository.findById(id).map(AgendamentoDTO::create);
	}

	@Override @Transactional(readOnly = true)
	public List<AgendamentoDTO> findAll() {
		return repository.findAll().stream().map(AgendamentoDTO::create).collect(Collectors.toList());
	}
}