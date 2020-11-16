package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;

import com.almarone.coletaseletiva.api.dto.DenunciaDTO;
import com.almarone.coletaseletiva.web.domain.Denuncia;

public interface DenunciaService {

	DenunciaDTO salvar(Denuncia denuncia);

	DenunciaDTO atualizar(Denuncia denuncia);

	void excluir(Long id);

	Optional<DenunciaDTO> listarDenunciaPorId(Long id);

	List<DenunciaDTO> listarDenuncias();

	List<DenunciaDTO> listarDenunciaPorBairro(Long idBairro);

	List<DenunciaDTO> listarDenunciaPorUsuario(Long idUsuario);
}
