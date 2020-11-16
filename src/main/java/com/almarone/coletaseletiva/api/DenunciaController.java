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

import com.almarone.coletaseletiva.api.dto.DenunciaDTO;
import com.almarone.coletaseletiva.web.domain.Denuncia;
import com.almarone.coletaseletiva.web.services.DenunciaService;

@RestController
@RequestMapping("/api/denuncias")
public class DenunciaController {

	@Autowired
	private DenunciaService service;

	@GetMapping()
	public ResponseEntity<List<DenunciaDTO>> listaDeDenuncia() {
		return ResponseEntity.ok(service.listarDenuncias());
	}

	@GetMapping("/{id}")
	public ResponseEntity listarDenunciaPorId(@PathVariable("id") Long id) {
		Optional<DenunciaDTO> denuncia = service.listarDenunciaPorId(id);
		if (!denuncia.isPresent()) {
			return ResponseEntity.badRequest().body("Denúncia com o ID informado não foi localizado");
		} else {
			return ResponseEntity.ok(denuncia);
		}
	}

	@GetMapping("/bairro/{idBairro}")
	public ResponseEntity listarDenunciaPorBairro(@PathVariable("idBairro") Long idBairro) {
		return ResponseEntity.ok(service.listarDenunciaPorBairro(idBairro));
	}

	@GetMapping("/usuario/{idUsuario}")
	public ResponseEntity listarDenunciaPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
		return ResponseEntity.ok(service.listarDenunciaPorUsuario(idUsuario));
	}

	@PostMapping()
	public ResponseEntity salvar(@RequestBody Denuncia denuncia) {
		try {
			return new ResponseEntity(service.salvar(denuncia), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody Denuncia denuncia) {
		return service.listarDenunciaPorId(id).map(entidade -> {
			try {
				denuncia.setId(entidade.getId());
				service.atualizar(denuncia);
				return ResponseEntity.ok(denuncia);
			} catch (Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}).orElseGet(() -> new ResponseEntity("Denúncia não encontrado", HttpStatus.BAD_REQUEST));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable("id") Long id) {
		return service.listarDenunciaPorId(id).map(entidade -> {
			service.excluir(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Denúncia não encontrado", HttpStatus.BAD_REQUEST));
	}

}
