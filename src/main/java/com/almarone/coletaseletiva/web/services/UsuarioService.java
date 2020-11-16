package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;

import com.almarone.coletaseletiva.api.dto.UsuarioDTO;
import com.almarone.coletaseletiva.web.domain.Usuario;

public interface UsuarioService {
	UsuarioDTO salvar(Usuario g);
	UsuarioDTO atualizar(Usuario g);
	void excluir(Long id);
	List<UsuarioDTO> listaUsuarios();
	Optional<UsuarioDTO> listarUsuarioPorId(Long id);
	
	// Regras de Negocio
	UsuarioDTO autenticar(String email, String senha);
	void validarEmail(String email);
	
}
