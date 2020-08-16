package com.almarone.coletaseletiva.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.almarone.coletaseletiva.web.domain.Bairro;
import com.almarone.coletaseletiva.web.services.BairroService;

@RestController
@RequestMapping("/api/bairros")
public class BairroController {
	@Autowired
	private BairroService service;

	@PostMapping
	public ResponseEntity salvar(@RequestBody Bairro bairro) {
		service.save(bairro);
		return ResponseEntity.ok().build();
	}
}
