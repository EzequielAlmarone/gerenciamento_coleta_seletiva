package com.almarone.coletaseletiva.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.almarone.coletaseletiva.web.domain.enums.DiaSemana;
import com.almarone.coletaseletiva.web.domain.enums.TipoColeta;

@Entity
@SuppressWarnings("serial")
public class Agendamento extends AbstractEntity<Long> {
	@Column(nullable = false, length = 20)
	private String horario;
	@Column(name = "dia_semana", nullable = false)
	private Integer diaSemana;
	@Column(name = "tipo_coleta", nullable = false)
	private Integer tipoColeta;
	
	@ManyToOne
	@JoinColumn(name = "bairro_id")
	private Bairro bairro;


	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public DiaSemana getDiaSemana() {		
		return DiaSemana.toEnum(this.diaSemana);
	}

	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}

	public TipoColeta getTipoColeta() {
		return TipoColeta.toEnum(this.tipoColeta);
	}

	public void setTipoColeta(Integer tipoColeta) {
		this.tipoColeta = tipoColeta;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	
	

	
	
	
	
	


}
