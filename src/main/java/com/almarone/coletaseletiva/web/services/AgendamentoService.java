package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;

import com.almarone.coletaseletiva.api.dto.AgendamentoDTO;
import com.almarone.coletaseletiva.web.domain.Agendamento;


public interface AgendamentoService {
	AgendamentoDTO salvar(Agendamento agendamento);
	AgendamentoDTO atualizar(Agendamento agendamento);
	void excluir(Long id);
	Optional<AgendamentoDTO> listarAgendamentoPorId(Long id);
	List<AgendamentoDTO> listarAgendamentos();
	List<AgendamentoDTO> listarAgendamentosPorBairro(Long idBairro);
}
