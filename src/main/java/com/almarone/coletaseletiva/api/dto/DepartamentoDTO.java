package com.almarone.coletaseletiva.api.dto;

import org.modelmapper.ModelMapper;

import com.almarone.coletaseletiva.web.domain.Departamento;

import lombok.Data;
@Data
public class DepartamentoDTO {
	
	private Long id;
	private String nome;

	public static DepartamentoDTO create(Departamento d) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(d, DepartamentoDTO.class);
	}
	
	

}
