package com.trabalho.poo.controllers;

import com.trabalho.poo.entities.Usuario;
import com.trabalho.poo.services.GenericService;
import com.trabalho.poo.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController extends GenericController<Usuario>{
	
	final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@Override
	GenericService<Usuario> getService() {
		return usuarioService;
	}

	@Operation(description = "Método para alterar o status do usuário")
	@PatchMapping("/status/{id}")
	public ResponseEntity<Object> alteraStatus(@PathVariable long id){
		try {
			usuarioService.alteraStatus(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

}
