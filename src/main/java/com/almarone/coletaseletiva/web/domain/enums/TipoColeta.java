package com.almarone.coletaseletiva.web.domain.enums;

public enum TipoColeta {

	COLETA_SELETIVA(1, "Coleta seletiva"), COLETA_COMUM(2, "Coleta comum");

	private int id;
	private String descricao;

	private TipoColeta(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return this.id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static TipoColeta toEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (TipoColeta x : TipoColeta.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}

}
