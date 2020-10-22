package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;

import com.almarone.coletaseletiva.api.dto.GestorDTO;
import com.almarone.coletaseletiva.web.domain.Gestor;

public interface GestorService {
	GestorDTO salvar(Gestor g);
	GestorDTO atualizar(Gestor g);
	void excluir(Long id);
	List<GestorDTO> listaGestores();
	Optional<GestorDTO> listarGestorPorId(Long id);
	
	// Regras de Negocio
	GestorDTO autenticar(String email, String senha);
	void validarEmail(String email);
	
}
