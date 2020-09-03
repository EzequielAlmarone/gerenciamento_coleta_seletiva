package com.almarone.coletaseletiva.web.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoColeta {

	COLETASELETIVA(1, "Coleta seletiva"), COLETACOMUM(2, "Coleta comum");

	private int id;
	private String descricao;
}
