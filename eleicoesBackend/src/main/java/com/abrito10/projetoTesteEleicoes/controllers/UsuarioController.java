package com.abrito10.projetoTesteEleicoes.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abrito10.projetoTesteEleicoes.dto.UsuarioDTO;
import com.abrito10.projetoTesteEleicoes.entidades.Usuario;
import com.abrito10.projetoTesteEleicoes.services.UsuarioService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Usuario obj = service.find(id);	
		return ResponseEntity.ok().body(obj);	
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	//@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<UsuarioDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	//@PostMapping
	public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);				
	}
}
