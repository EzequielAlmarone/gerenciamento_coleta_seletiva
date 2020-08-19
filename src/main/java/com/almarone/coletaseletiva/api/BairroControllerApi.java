package com.almarone.coletaseletiva.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almarone.coletaseletiva.api.dto.BairroDTO;
import com.almarone.coletaseletiva.web.services.BairroServiceImpl;

@RestController
@RequestMapping("/api/bairros")
public class BairroControllerApi {
	@Autowired
	private BairroServiceImpl service;
	
	@GetMapping()
	public ResponseEntity<List<BairroDTO>> listaDeBairros(){
	return ResponseEntity.ok(service.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity buscarBairroPorId(@PathVariable("id") Long id){
	Optional<BairroDTO> bairro = service.findById(id);
	if(!bairro.isPresent()) {
	return ResponseEntity.badRequest().body("Informe um bairro válido");
	} else {
	return ResponseEntity.ok(bairro);
	}
	}
	
	
}
