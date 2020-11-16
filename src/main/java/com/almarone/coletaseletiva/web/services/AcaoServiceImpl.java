package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almarone.coletaseletiva.api.dto.AcaoDTO;
import com.almarone.coletaseletiva.web.domain.Acao;
import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.domain.Gestor;
import com.almarone.coletaseletiva.web.domain.exception.RegraDeNegocioException;
import com.almarone.coletaseletiva.web.repository.AcaoRepository;
import com.almarone.coletaseletiva.web.repository.BairroRepository;
import com.almarone.coletaseletiva.web.repository.GestorRepository;


@Service @Transactional(readOnly = false)
public class AcaoServiceImpl implements AcaoService {
	
	@Autowired
	private AcaoRepository repository;
	@Autowired
	private BairroRepository bairroRepository;
	@Autowired
	private GestorRepository gestorRepository;

	@Override
	public AcaoDTO salvar(Acao acao) {
		return AcaoDTO.create(repository.save(acao));
	}

	@Override
	public AcaoDTO atualizar(Acao acao) {
		return AcaoDTO.create(repository.save(acao));
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);
		
	}

	@Override @Transactional(readOnly = true)
	public Optional<AcaoDTO> listarAcaoPorId(Long id) {
		return repository.findById(id).map(AcaoDTO::create);
	}

	@Override @Transactional(readOnly = true)
	public List<AcaoDTO> listarAcao() {
		return repository.findAll().stream()
				.map(AcaoDTO::create)
				.collect(Collectors.toList());
	}

	@Override @Transactional(readOnly = true)
	public List<AcaoDTO> listarAcaoPorBairro(Long idBairro) {
		Bairro bairro = bairroRepository
				.findById(idBairro)
				.orElseThrow(() -> new RegraDeNegocioException("Bairro não encontrado"));
		return repository.findByBairro(bairro)
				.stream().map(AcaoDTO::create).collect(Collectors.toList());
	}
	
	@Override @Transactional(readOnly = true)
	public List<AcaoDTO> listarAcaoPorGestor(Long idGestor) {
		Gestor gestor = gestorRepository
				.findById(idGestor)
				.orElseThrow(() -> new RegraDeNegocioException("Gestor não encontrado"));
		return repository.findByGestor(gestor)
				.stream().map(AcaoDTO::create).collect(Collectors.toList());
	}
}