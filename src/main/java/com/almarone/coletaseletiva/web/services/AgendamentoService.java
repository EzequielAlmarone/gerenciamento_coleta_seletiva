package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;

import com.almarone.coletaseletiva.api.dto.AgendamentoDTO;
import com.almarone.coletaseletiva.web.domain.Agendamento;


public interface AgendamentoService {
	Agendamento save(Agendamento agendamento);
	Agendamento update(Agendamento agendamento);
	void delete(Long id);
	Optional<AgendamentoDTO> findById(Long id);
	List<AgendamentoDTO> findAll();
}
