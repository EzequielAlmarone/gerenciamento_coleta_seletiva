package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;

import com.almarone.coletaseletiva.api.dto.AcaoDTO;
import com.almarone.coletaseletiva.web.domain.Acao;

public interface AcaoService {

	AcaoDTO salvar(Acao acao);

	AcaoDTO atualizar(Acao acao);

	void excluir(Long id);

	Optional<AcaoDTO> listarAcaoPorId(Long id);

	List<AcaoDTO> listarAcao();

	List<AcaoDTO> listarAcaoPorBairro(Long idBairro);
	
	List<AcaoDTO> listarAcaoPorGestor(Long idGestor);
}
