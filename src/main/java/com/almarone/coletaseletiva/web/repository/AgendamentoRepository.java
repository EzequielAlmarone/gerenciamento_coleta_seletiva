package com.almarone.coletaseletiva.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.almarone.coletaseletiva.web.domain.Agendamento;
import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.domain.enums.DiaSemana;
import com.almarone.coletaseletiva.web.domain.enums.TipoColeta;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
	
	/**
	 * select bairro, dia_semana, tipo_coleta
	 * from agendamento
	 * where bairro = ? and dia_semana = ? and tipo_coleta = ?
	 */
	
	@Query (value = "select a.bairro, a.diaSemana, a.tipoColeta "
			+ "from Agendamento a"
			+ " where a.bairro = :bairro and diaSemana = :diaSemana"
			+ " and tipoColeta = :tipoColeta")
	
	Optional<Agendamento> compararAgendamento(
			@Param("bairro") Bairro bairro,
			@Param("diaSemana") DiaSemana diaSemana,
			@Param("tipoColeta") TipoColeta tipoColeta);
	
	
	/**
	 * 
	 * @param bairro
	 * @return -> lista de agendamentos para o bairro consultado.
	 */
	List<Agendamento> findByBairro(Bairro bairro);
	
}
