package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;

import com.almarone.coletaseletiva.api.dto.EducacaoAmbientalDTO;
import com.almarone.coletaseletiva.web.domain.EducacaoAmbiental;

public interface EducacaoAmbientalService {
	
	EducacaoAmbientalDTO salvar(EducacaoAmbiental educacao);

	EducacaoAmbientalDTO atualizar(EducacaoAmbiental educacao);

	void excluir(Long id);

	List<EducacaoAmbientalDTO> listaEducacaoAmbiental();

	Optional<EducacaoAmbientalDTO> listarEducacaoAmbientalPorId(Long id);

	List<EducacaoAmbientalDTO> listaEducacaoAmbientalPorGestor(Long idGestor);

}
