package com.almarone.coletaseletiva.api.dto;

import org.modelmapper.ModelMapper;

import com.almarone.coletaseletiva.web.domain.Bairro;

import lombok.Data;
@Data
public class BairroDTO {
	
	private Long id;
	private String nome;
	
	public static BairroDTO create(Bairro bairro) {
		ModelMapper modelMaper = new ModelMapper();
		return modelMaper.map(bairro, BairroDTO.class);
	}
}
