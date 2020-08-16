package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.domain.exception.RegraDeNegocioException;
import com.almarone.coletaseletiva.web.repository.BairroDao;


@Service @Transactional(readOnly = false)
public class BairroServiceImpl implements BairroService {
	@Autowired
	private BairroDao dao;

	@Override
	public void save(Bairro bairro) {
		dao.save(bairro);
		
	}

	@Override
	public void update(Bairro bairro) {
		dao.update(bairro);
		
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);	
	}

	@Override @Transactional(readOnly = true)
	public Bairro findById(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Bairro> findAll() {
		return dao.findAll();
	}

	@Override
	public void bairroDuplicado(String nomeBairro) {
		Optional<Bairro> bairro = dao.findByNome(nomeBairro);
		if(bairro.get().getNome().equals(nomeBairro)) {
			throw new RegraDeNegocioException("Esse bairro já foi cadastrado!");
		}
		
	}
}