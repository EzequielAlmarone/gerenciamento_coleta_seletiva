package com.almarone.coletaseletiva.api.dto;

import java.sql.Date;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import com.almarone.coletaseletiva.web.domain.EducacaoAmbiental;
import com.almarone.coletaseletiva.web.domain.Gestor;
import lombok.Data;

@Data
public class EducacaoAmbientalDTO {
	private Long id;
	private String titulo;
	private ArrayList<String> fotos;
	private String descricao;
	private Date data;
	private Gestor gestor;

	public static EducacaoAmbientalDTO create(EducacaoAmbiental e) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(e, EducacaoAmbientalDTO.class);
	}
}
