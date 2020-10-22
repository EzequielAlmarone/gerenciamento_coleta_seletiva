package com.almarone.coletaseletiva.api.dto;

import org.modelmapper.ModelMapper;

import com.almarone.coletaseletiva.web.domain.Departamento;
import com.almarone.coletaseletiva.web.domain.Gestor;

import lombok.Data;

@Data
public class GestorDTO {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cargo;
	private Departamento departamento;
	
	public static GestorDTO create(Gestor g) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(g, GestorDTO.class);
	}
}
