package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almarone.coletaseletiva.api.dto.GestorDTO;
import com.almarone.coletaseletiva.web.domain.Gestor;
import com.almarone.coletaseletiva.web.domain.exception.ErroAutenticacaoException;
import com.almarone.coletaseletiva.web.domain.exception.RegraDeNegocioException;
import com.almarone.coletaseletiva.web.repository.GestorRepository;

@Service
@Transactional(readOnly = false)
public class GestorServiceImpl implements GestorService {

	@Autowired
	private GestorRepository repository;

	@Override
	public GestorDTO salvar(Gestor gestor) {
		validarEmail(gestor.getEmail());
		return GestorDTO.create(repository.save(gestor));
	}

	@Override
	public GestorDTO atualizar(Gestor gestor) {
		//validarEmail(gestor.getEmail());
		return GestorDTO.create(repository.save(gestor));
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GestorDTO> listaGestores() {
		return repository.findAll().stream().map(GestorDTO::create).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<GestorDTO> listarGestorPorId(Long id) {
		return repository.findById(id).map(GestorDTO::create);
	}

	// Regra de Negocio
	
	@Override
	public GestorDTO autenticar(String email, String senha) {
		Optional<Gestor> gestor = repository.findByEmail(email);
		if (!gestor.isPresent()) {
			throw new ErroAutenticacaoException("O email do usuário não foi localizado");
		}
		if (!gestor.get().getSenha().equals(senha)) {
			throw new ErroAutenticacaoException("A Senha está incorreta");
		}
		return GestorDTO.create(gestor.get());
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if (existe) {
			throw new RegraDeNegocioException("Já existe um gestor cadastrado com este email");
		}
	}

}
