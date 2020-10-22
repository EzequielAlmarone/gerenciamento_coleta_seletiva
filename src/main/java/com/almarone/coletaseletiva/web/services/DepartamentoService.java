package com.almarone.coletaseletiva.web.services;

import java.util.List;
import java.util.Optional;

import com.almarone.coletaseletiva.api.dto.DepartamentoDTO;
import com.almarone.coletaseletiva.web.domain.Departamento;

public interface DepartamentoService {
	
	DepartamentoDTO salvar(Departamento d);
	DepartamentoDTO atualizar(Departamento d);
	void excluir(Long id);
	List<DepartamentoDTO> listaDepartamentos();
	Optional<DepartamentoDTO> listarDepartamentoPorId(Long id);
}
