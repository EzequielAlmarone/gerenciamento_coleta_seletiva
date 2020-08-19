package com.almarone.coletaseletiva.api.dto;

import org.modelmapper.ModelMapper;

import com.almarone.coletaseletiva.web.domain.Bairro;

public class BairroDTO {
	
	private Long id;
	private String nome;
	
	public static BairroDTO create(Bairro bairro) {
		ModelMapper modelMaper = new ModelMapper();
		return modelMaper.map(bairro, BairroDTO.class);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
