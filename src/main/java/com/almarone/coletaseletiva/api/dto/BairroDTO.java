package com.almarone.coletaseletiva.api.dto;

import com.almarone.coletaseletiva.web.domain.Bairro;

public class BairroDTO {
	
	private Long id;
	private String nome;
	
	public BairroDTO(Bairro bairro) {
		this.id = bairro.getId();
		this.nome = bairro.getNome();
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
