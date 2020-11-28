package com.almarone.coletaseletiva.api.dto;


import java.sql.Date;

import org.modelmapper.ModelMapper;

import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.domain.Denuncia;
import com.almarone.coletaseletiva.web.domain.Usuario;

import lombok.Data;

@Data
public class DenunciaDTO {

	private Long id;
	private String descricao;
	private String foto;
	private Date data;
	private Bairro bairro;
	private Usuario usuario;

	public static DenunciaDTO create(Denuncia denuncia) {
		ModelMapper modelMaper = new ModelMapper();
		return modelMaper.map(denuncia, DenunciaDTO.class);
	}
}
