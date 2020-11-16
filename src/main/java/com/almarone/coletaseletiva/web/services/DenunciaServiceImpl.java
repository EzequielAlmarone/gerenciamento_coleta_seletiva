package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almarone.coletaseletiva.api.dto.DenunciaDTO;
import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.domain.Denuncia;
import com.almarone.coletaseletiva.web.domain.Usuario;
import com.almarone.coletaseletiva.web.domain.exception.RegraDeNegocioException;
import com.almarone.coletaseletiva.web.repository.BairroRepository;
import com.almarone.coletaseletiva.web.repository.DenunciaRepository;
import com.almarone.coletaseletiva.web.repository.UsuarioRepository;

@Service
@Transactional(readOnly = false)
public class DenunciaServiceImpl implements DenunciaService {

	@Autowired
	private DenunciaRepository repository;

	@Autowired
	private BairroRepository bairroRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public DenunciaDTO salvar(Denuncia denuncia) {
		return DenunciaDTO.create(repository.save(denuncia));
	}

	@Override
	public DenunciaDTO atualizar(Denuncia denuncia) {
		return DenunciaDTO.create(repository.save(denuncia));
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DenunciaDTO> listarDenunciaPorId(Long id) {
		return repository.findById(id).map(DenunciaDTO::create);
	}

	@Override
	public List<DenunciaDTO> listarDenuncias() {
		return repository.findAll().stream().map(DenunciaDTO::create).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<DenunciaDTO> listarDenunciaPorBairro(Long idBairro) {
		Bairro bairro = bairroRepository.findById(idBairro)
				.orElseThrow(() -> new RegraDeNegocioException("Bairro não encontrado"));
		return repository.findByBairro(bairro).stream().map(DenunciaDTO::create).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<DenunciaDTO> listarDenunciaPorUsuario(Long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new RegraDeNegocioException("Usuário não encontrado"));
		return repository.findByUsuario(usuario).stream().map(DenunciaDTO::create).collect(Collectors.toList());
	}
}