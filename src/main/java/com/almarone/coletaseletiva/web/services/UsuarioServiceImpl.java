package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almarone.coletaseletiva.api.dto.UsuarioDTO;
import com.almarone.coletaseletiva.web.domain.Usuario;
import com.almarone.coletaseletiva.web.domain.exception.ErroAutenticacaoException;
import com.almarone.coletaseletiva.web.domain.exception.RegraDeNegocioException;
import com.almarone.coletaseletiva.web.repository.UsuarioRepository;

@Service
@Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UsuarioDTO salvar(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return UsuarioDTO.create(repository.save(usuario));
	}

	@Override
	public UsuarioDTO atualizar(Usuario usuario) {
		return UsuarioDTO.create(repository.save(usuario));
	}
	
	@Override
	public void excluir(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UsuarioDTO> listaUsuarios() {
		return repository.findAll().stream().map(UsuarioDTO::create).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UsuarioDTO> listarUsuarioPorId(Long id) {
		return repository.findById(id).map(UsuarioDTO::create);
	}

	// Regra de Negocio
	
	@Override
	public UsuarioDTO autenticar(String email, String senha) {
		Optional<Usuario> usuario = repository.findByEmail(email);
		if (!usuario.isPresent()) {
			throw new ErroAutenticacaoException("O email do usuário não foi localizado");
		}
		if (!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacaoException("A Senha está incorreta");
		}
		return UsuarioDTO.create(usuario.get());
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if (existe) {
			throw new RegraDeNegocioException("Já existe um usuário cadastrado com este email");
		}
	}

}
