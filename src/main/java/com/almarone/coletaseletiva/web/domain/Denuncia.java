package com.almarone.coletaseletiva.web.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Denuncia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Lob
	private String descricao;
	private String fotos;
	@ManyToOne
	@JoinColumn(name = "fk_bairro_id")
	private Bairro bairro;
	@ManyToOne
	@JoinColumn(name = "fk_usuario_id")
	private Usuario usuario;

}
