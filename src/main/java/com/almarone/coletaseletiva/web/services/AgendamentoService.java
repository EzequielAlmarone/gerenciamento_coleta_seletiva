package com.almarone.coletaseletiva.web.services;

import java.util.List;

import com.almarone.coletaseletiva.web.domain.Agendamento;


public interface AgendamentoService {
	void save(Agendamento agendamento);
	void update(Agendamento agendamento);
	void delete(Long id);
	Agendamento findById(Long id);
	List<Agendamento> findAll();
}
