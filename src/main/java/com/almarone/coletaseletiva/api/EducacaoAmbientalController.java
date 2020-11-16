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

import com.almarone.coletaseletiva.api.dto.EducacaoAmbientalDTO;
import com.almarone.coletaseletiva.api.dto.GestorDTO;
import com.almarone.coletaseletiva.web.domain.EducacaoAmbiental;
import com.almarone.coletaseletiva.web.domain.Gestor;
import com.almarone.coletaseletiva.web.services.EducacaoAmbientalService;
import com.almarone.coletaseletiva.web.services.GestorService;

@RestController
@RequestMapping("/api/educacoes")
public class EducacaoAmbientalController {

	@Autowired
	public EducacaoAmbientalService service;

	@GetMapping()
	public ResponseEntity<List<EducacaoAmbientalDTO>> listaDeEducacaoAmbiental() {
		return ResponseEntity.ok(service.listaEducacaoAmbiental());
	}

	@GetMapping("/{id}")
	public ResponseEntity listarEducaoAmbientalPorId(@PathVariable("id") Long id) {
		Optional<EducacaoAmbientalDTO> educacao = service.listarEducacaoAmbientalPorId(id);
		if (!educacao.isPresent()) {
			return ResponseEntity.badRequest().body("Educacão Ambiental com o ID informado não foi localizado");
		} else {
			return ResponseEntity.ok(educacao);
		}
	}
	
	@GetMapping("/gestor/{idGestor}")
	public ResponseEntity listarEducaoAmbientalPorGestor(@PathVariable("idGestor") Long idGestor) {
		return ResponseEntity.ok(service.listaEducacaoAmbientalPorGestor(idGestor));
	}

	@PostMapping()
	public ResponseEntity salvar(@RequestBody EducacaoAmbiental educacao) {
		try {
			EducacaoAmbientalDTO dto = service.salvar(educacao);
			return new ResponseEntity(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody EducacaoAmbiental educacao) {
		return service.listarEducacaoAmbientalPorId(id).map(entidade -> {
			try {
				educacao.setId(entidade.getId());
				service.atualizar(educacao);
				return ResponseEntity.ok(educacao);
			} catch (Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}).orElseGet(() -> new ResponseEntity("Educação Ambiental não encontrado", HttpStatus.BAD_REQUEST));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable("id") Long id) {
		return service.listarEducacaoAmbientalPorId(id).map(entidade -> {
			service.excluir(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Educação Ambiental não encontrado", HttpStatus.BAD_REQUEST));
	}
}
