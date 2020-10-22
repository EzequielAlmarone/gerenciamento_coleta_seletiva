package com.almarone.coletaseletiva.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almarone.coletaseletiva.api.dto.GestorDTO;
import com.almarone.coletaseletiva.web.domain.Gestor;
import com.almarone.coletaseletiva.web.services.GestorService;

@RestController
@RequestMapping("/api/gestores")
public class GestorController {

	@Autowired
	public GestorService service;

	@GetMapping()
	public ResponseEntity<List<GestorDTO>> listaDeGestores() {
		return ResponseEntity.ok(service.listaGestores());
	}

	@GetMapping("/{id}")
	public ResponseEntity listarGestoresPorId(@PathVariable("id") Long id) {
		Optional<GestorDTO> gestor = service.listarGestorPorId(id);
		if (!gestor.isPresent()) {
			return ResponseEntity.badRequest().body("O Gestor para o ID informado não foi localizado");
		} else {
			return ResponseEntity.ok(gestor);
		}
	}
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody GestorDTO gestor) {
		try {
			GestorDTO gestorAutenticado = service.autenticar(gestor.getEmail(), gestor.getSenha());
			return ResponseEntity.ok(gestorAutenticado);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}

	@PostMapping()
	public ResponseEntity salvar(@RequestBody Gestor gestor) {
		try {
			GestorDTO dto = service.salvar(gestor);
			return new ResponseEntity(dto, HttpStatus.CREATED);	
		} catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody Gestor gestor) {
		return service.listarGestorPorId(id).map(entidade -> {
			try {
				gestor.setId(entidade.getId());
				service.atualizar(gestor);
				return ResponseEntity.ok(gestor);
			} catch (Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}).orElseGet(()-> new ResponseEntity("Gestor não encontrado", HttpStatus.BAD_REQUEST));

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable("id") Long id) {
		return service.listarGestorPorId(id).map(entidade -> { 
			service.excluir(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}).orElseGet(()-> new ResponseEntity("Gestor não encontrado", HttpStatus.BAD_REQUEST));
	}
}
