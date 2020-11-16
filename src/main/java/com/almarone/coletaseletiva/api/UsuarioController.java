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

import com.almarone.coletaseletiva.api.dto.BairroDTO;
import com.almarone.coletaseletiva.api.dto.GestorDTO;
import com.almarone.coletaseletiva.api.dto.UsuarioDTO;
import com.almarone.coletaseletiva.web.domain.Gestor;
import com.almarone.coletaseletiva.web.domain.Usuario;
import com.almarone.coletaseletiva.web.services.BairroService;
import com.almarone.coletaseletiva.web.services.GestorService;
import com.almarone.coletaseletiva.web.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	public UsuarioService service;
	
	@Autowired
	public BairroService bairroService;

	@GetMapping()
	public ResponseEntity<List<UsuarioDTO>> listaDeUsuarios() {
		return ResponseEntity.ok(service.listaUsuarios());
	}

	@GetMapping("/{id}")
	public ResponseEntity listarUsuariosPorId(@PathVariable("id") Long id) {
		Optional<UsuarioDTO> usuario = service.listarUsuarioPorId(id);
		if (!usuario.isPresent()) {
			return ResponseEntity.badRequest().body("O Usuário para o ID informado não foi localizado");
		} else {
			return ResponseEntity.ok(usuario);
		}
	}
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody UsuarioDTO usuario) {
		try {
			UsuarioDTO usuarioAutenticado = service.autenticar(usuario.getEmail(), usuario.getSenha());
			return ResponseEntity.ok(usuarioAutenticado);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}

	@PostMapping()
	public ResponseEntity salvar(@RequestBody Usuario usuario) {
		try {
			Optional<BairroDTO> bairroDTO = bairroService.listarBairroPorId(usuario.getBairro().getId());
			if(bairroDTO.isPresent()) {
				UsuarioDTO dto = service.salvar(usuario);
				dto.getBairro().setNome(bairroDTO.get().getNome());
				return new ResponseEntity(dto, HttpStatus.CREATED);
			}else {
				return new ResponseEntity("Bairro não encontrado", HttpStatus.BAD_REQUEST);
			}
				
		} catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		return service.listarUsuarioPorId(id).map(entidade -> {
			try {
				usuario.setId(entidade.getId());
				service.atualizar(usuario);
				return ResponseEntity.ok(usuario);
			} catch (Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}).orElseGet(()-> new ResponseEntity("Usuário não encontrado", HttpStatus.BAD_REQUEST));

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable("id") Long id) {
		return service.listarUsuarioPorId(id).map(entidade -> { 
			service.excluir(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}).orElseGet(()-> new ResponseEntity("Usuário não encontrado", HttpStatus.BAD_REQUEST));
	}
}
