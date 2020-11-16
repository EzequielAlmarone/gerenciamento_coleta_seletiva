package com.almarone.coletaseletiva.api.dto;

import org.modelmapper.ModelMapper;

import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.domain.Usuario;

import lombok.Data;

@Data
public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Bairro bairro;
	
	public static UsuarioDTO create(Usuario u) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(u, UsuarioDTO.class);
	}
}
