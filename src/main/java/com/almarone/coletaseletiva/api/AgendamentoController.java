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

import com.almarone.coletaseletiva.api.dto.AgendamentoDTO;
import com.almarone.coletaseletiva.web.domain.Agendamento;
import com.almarone.coletaseletiva.web.services.AgendamentoService;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService service;

	@GetMapping()
	public ResponseEntity<List<AgendamentoDTO>> listarAgendamentos(){
		return ResponseEntity.ok(service.listarAgendamentos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity listarAgendamentoPorId(@PathVariable("id") Long id){
		Optional<AgendamentoDTO> dto = service.listarAgendamentoPorId(id);
		if(!dto.isPresent()) {
			return ResponseEntity.badRequest().body("Agendamento com Id informado não encontrado!");
		}else {
			return ResponseEntity.ok(dto);
		}
	}
	
	@GetMapping("/bairro/{idBairro}")
	public ResponseEntity listarAgendamentoPorBairro(@PathVariable("idBairro") Long idBairro) {
		return ResponseEntity.ok(service.listarAgendamentosPorBairro(idBairro));	
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody Agendamento agendamento) {
		try {
			AgendamentoDTO agendamentoDTO = service.salvar(agendamento);
			return new ResponseEntity(agendamentoDTO, HttpStatus.CREATED);	
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody Agendamento agendamento) {
		return service.listarAgendamentoPorId(id).map(entity -> {
			try {				
				agendamento.setId(entity.getId());
				service.atualizar(agendamento);
				return ResponseEntity.ok(agendamento);
			} catch (Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}			
		}).orElseGet(() -> new ResponseEntity("Agendamento não encontrado na base de dados", HttpStatus.BAD_REQUEST));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable("id") Long id){						
		return service.listarAgendamentoPorId(id).map(entidade -> {			
			service.excluir(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Agendamento não encontrado na base de dados", HttpStatus.BAD_REQUEST));
	}
}
