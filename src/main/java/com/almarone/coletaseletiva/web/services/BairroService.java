package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;

import com.almarone.coletaseletiva.api.dto.BairroDTO;
import com.almarone.coletaseletiva.web.domain.Bairro;


public interface BairroService{
	BairroDTO salvar(Bairro bairro);
	BairroDTO atualizar(Bairro bairro);
	void excluir(Long id);
	List<BairroDTO> listarBairros();
	Optional<BairroDTO> listarBairroPorId(Long id);
	
	
	// Regras de Negocio
	
	//void bairroDuplicado(String nomeBairro);
	
}
