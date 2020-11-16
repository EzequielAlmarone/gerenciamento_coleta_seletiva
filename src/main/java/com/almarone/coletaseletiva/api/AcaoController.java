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

import com.almarone.coletaseletiva.api.dto.AcaoDTO;
import com.almarone.coletaseletiva.web.domain.Acao;
import com.almarone.coletaseletiva.web.services.AcaoService;

@RestController
@RequestMapping("/api/acoes")
public class AcaoController {

	@Autowired
	private AcaoService service;

	@GetMapping()
	public ResponseEntity<List<AcaoDTO>> listaDeAcoes() {
		return ResponseEntity.ok(service.listarAcao());
	}

	@GetMapping("/{id}")
	public ResponseEntity listarAcaoPorId(@PathVariable("id") Long id) {
		Optional<AcaoDTO> acao = service.listarAcaoPorId(id);
		if (!acao.isPresent()) {
			return ResponseEntity.badRequest().body("Ação com o ID informado não foi localizado");
		} else {
			return ResponseEntity.ok(acao);
		}
	}

	@GetMapping("/bairro/{idBairro}")
	public ResponseEntity listarAcaoPorBairro(@PathVariable("idBairro") Long idBairro) {
		return ResponseEntity.ok(service.listarAcaoPorBairro(idBairro));
	}

	@GetMapping("/gestor/{idGestor}")
	public ResponseEntity listarAcaoPorGestor(@PathVariable("idGestor") Long idGestor) {
		return ResponseEntity.ok(service.listarAcaoPorGestor(idGestor));
	}

	@PostMapping()
	public ResponseEntity salvar(@RequestBody Acao acao) {
		try {
			
			return new ResponseEntity(service.salvar(acao), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody Acao acao) {
		return service.listarAcaoPorId(id).map(entidade -> {
			try {
				acao.setId(entidade.getId());
				service.atualizar(acao);
				return ResponseEntity.ok(acao);
			} catch (Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}).orElseGet(() -> new ResponseEntity("Ação não encontrada", HttpStatus.BAD_REQUEST));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable("id") Long id) {
		return service.listarAcaoPorId(id).map(entidade -> {
			service.excluir(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Ação não encontrado", HttpStatus.BAD_REQUEST));
	}

}
