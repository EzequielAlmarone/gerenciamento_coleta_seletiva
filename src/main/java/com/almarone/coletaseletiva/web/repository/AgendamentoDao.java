package com.almarone.coletaseletiva.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almarone.coletaseletiva.web.domain.Agendamento;


public interface AgendamentoDao extends JpaRepository<Agendamento, Long>{
	
}
