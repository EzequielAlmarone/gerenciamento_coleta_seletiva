package com.almarone.coletaseletiva.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;


@SuppressWarnings("serial")
@Entity
public class Bairro extends AbstractEntity<Long> {
	@Column(nullable = false, unique = true, length = 120)
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
