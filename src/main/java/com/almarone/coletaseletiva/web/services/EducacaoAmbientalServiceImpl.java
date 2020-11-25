package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almarone.coletaseletiva.api.dto.EducacaoAmbientalDTO;
import com.almarone.coletaseletiva.web.domain.EducacaoAmbiental;
import com.almarone.coletaseletiva.web.domain.Gestor;
import com.almarone.coletaseletiva.web.domain.exception.RegraDeNegocioException;
import com.almarone.coletaseletiva.web.repository.EducacaoAmbientalRepository;
import com.almarone.coletaseletiva.web.repository.GestorRepository;

@Service
@Transactional(readOnly = false)
public class EducacaoAmbientalServiceImpl implements EducacaoAmbientalService {

	@Autowired
	private EducacaoAmbientalRepository repository;

	@Autowired
	private GestorRepository gestorRepository;

	@Override
	public EducacaoAmbientalDTO salvar(EducacaoAmbiental educacao) {
		return EducacaoAmbientalDTO.create(repository.save(educacao));
	}

	@Override
	public EducacaoAmbientalDTO atualizar(EducacaoAmbiental educacao) {
		return EducacaoAmbientalDTO.create(repository.save(educacao));
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EducacaoAmbientalDTO> listaEducacaoAmbiental() {
		return repository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream().map(EducacaoAmbientalDTO::create).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<EducacaoAmbientalDTO> listarEducacaoAmbientalPorId(Long id) {
		return repository.findById(id).map(EducacaoAmbientalDTO::create);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EducacaoAmbientalDTO> listaEducacaoAmbientalPorGestor(Long idGestor) {
		Gestor gestor = gestorRepository.findById(idGestor)
				.orElseThrow(() -> new RegraDeNegocioException("Gestor não encontrado"));
		return repository.findByGestor(gestor).stream().map(EducacaoAmbientalDTO::create).collect(Collectors.toList());
	}

}
