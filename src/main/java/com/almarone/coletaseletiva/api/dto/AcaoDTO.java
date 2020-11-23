package com.almarone.coletaseletiva.api.dto;


import java.util.ArrayList;
import java.util.Date;

import org.modelmapper.ModelMapper;

import com.almarone.coletaseletiva.web.domain.Acao;
import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.domain.Gestor;

import lombok.Data;
@Data
public class AcaoDTO {
	
	private Long id;
	private String titulo;
	private String descricao;
	private ArrayList<String> fotos;
	private Date date;
	private Bairro bairro;
	private Gestor gestor;
	
	public static AcaoDTO create(Acao acao) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(acao, AcaoDTO.class);
	}
}
