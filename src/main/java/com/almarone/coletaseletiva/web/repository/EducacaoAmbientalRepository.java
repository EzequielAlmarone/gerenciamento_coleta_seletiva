package com.almarone.coletaseletiva.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almarone.coletaseletiva.web.domain.EducacaoAmbiental;
import com.almarone.coletaseletiva.web.domain.Gestor;


public interface EducacaoAmbientalRepository extends JpaRepository<EducacaoAmbiental, Long>{
	/**
	 * 
	 * @param EducacaoAmbiental
	 * @return -> lista de EducacaoAmbiental para o gestor consultado.
	 */
	List<EducacaoAmbiental> findByGestor(Gestor gestor);
	
}
