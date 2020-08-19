package com.almarone.coletaseletiva.api.dto;

import org.modelmapper.ModelMapper;

import com.almarone.coletaseletiva.web.domain.Agendamento;

public class AgendamentoDTO {
	
	private Long id;
	private String horario;

	
	public static AgendamentoDTO create(Agendamento agendamento) {
		ModelMapper modelMaper = new ModelMapper();
		return modelMaper.map(agendamento, AgendamentoDTO.class);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return horario;
	}

	public void setNome(String horario) {
		this.horario = horario;
	}
	
	

	
}
