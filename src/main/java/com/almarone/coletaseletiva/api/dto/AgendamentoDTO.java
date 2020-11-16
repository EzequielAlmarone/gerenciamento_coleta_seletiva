package com.almarone.coletaseletiva.api.dto;

import org.modelmapper.ModelMapper;

import com.almarone.coletaseletiva.web.domain.Agendamento;
import com.almarone.coletaseletiva.web.domain.Bairro;

import lombok.Data;
@Data
public class AgendamentoDTO {
	
	private Long id;
	private String horario;
	private String diaSemana;
	private String tipoColeta;
	private Bairro bairro;

	
	public static AgendamentoDTO create(Agendamento agendamento) {
		ModelMapper modelMaper = new ModelMapper();
		return modelMaper.map(agendamento, AgendamentoDTO.class);
	}	
}
