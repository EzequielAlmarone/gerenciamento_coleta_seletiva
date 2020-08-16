package com.almarone.coletaseletiva.web.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@SuppressWarnings("serial")
@Entity
public class Bairro extends AbstractEntity<Long> {
	@Column(nullable = false, unique = true, length = 120)
	private String nome;
	
	@OneToMany(mappedBy = "bairro")
	private List<Agendamento> agendamentos = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
