package com.almarone.coletaseletiva.web.repository;

import java.util.List;

import com.almarone.coletaseletiva.web.domain.Agendamento;


public interface AgendamentoDao {
	
	Agendamento save(Agendamento bairro);
	void update(Agendamento bairro);
	void delete(Long id);
	Agendamento findById(Long id);
	List<Agendamento> findAll();

}
