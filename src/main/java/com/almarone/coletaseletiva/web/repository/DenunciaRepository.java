package com.almarone.coletaseletiva.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.domain.Denuncia;
import com.almarone.coletaseletiva.web.domain.Usuario;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
	// listar denuncia por bairro
	List<Denuncia> findByBairro(Bairro bairro);

	// listar denuncia por usuário
	List<Denuncia> findByUsuario(Usuario usuario);

}
