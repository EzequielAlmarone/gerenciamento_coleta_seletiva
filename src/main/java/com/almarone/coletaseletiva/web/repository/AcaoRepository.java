package com.almarone.coletaseletiva.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almarone.coletaseletiva.web.domain.Acao;
import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.domain.Gestor;


public interface AcaoRepository extends JpaRepository<Acao, Long>{

	List<Acao> findByBairro(Bairro bairro);
	List<Acao> findByGestor(Gestor gestor);	
}
