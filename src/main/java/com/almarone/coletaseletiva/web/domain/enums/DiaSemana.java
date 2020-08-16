package com.almarone.coletaseletiva.web.domain.enums;

public enum DiaSemana {

	DOMINGO(1, "Domingo"), SEGUNDA_FEIRA(2, "Segunda-feira"), TERCA_FEIRA(3, "Terça-feira"),
	QUARTA_FEIRA(4, "Quarta-feira"), QUINTA_FEIRA(5, "Quinta-feira"), SEXTA_FEIRA(6, "Sexta-feira"),
	SABADO(7, "Sábado");

	private int id;
	private String descricao;

	private DiaSemana(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return this.id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static DiaSemana toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (DiaSemana x : DiaSemana.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id Invalido: " + id);
	}

}
