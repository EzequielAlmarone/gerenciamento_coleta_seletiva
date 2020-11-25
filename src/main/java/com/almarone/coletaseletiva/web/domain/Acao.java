package com.almarone.coletaseletiva.web.domain;

import java.sql.Date;
import java.util.ArrayList;

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
public class Acao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	@Lob
	private String descricao;
	private ArrayList<String> fotos;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "fk_bairro_id")
	private Bairro bairro;
	
	@ManyToOne
	@JoinColumn(name = "fk_gestor_id")
	private Gestor gestor;

}
