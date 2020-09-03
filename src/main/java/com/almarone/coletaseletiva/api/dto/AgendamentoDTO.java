package com.almarone.coletaseletiva.api.dto;

import org.modelmapper.ModelMapper;

import com.almarone.coletaseletiva.web.domain.Agendamento;
import com.almarone.coletaseletiva.web.domain.Bairro;

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

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getTipoColeta() {
		return tipoColeta;
	}

	public void setTipoColeta(String tipoColeta) {
		this.tipoColeta = tipoColeta;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	

	
}
