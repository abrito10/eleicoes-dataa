package com.abrito10.projetoTesteEleicoes.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abrito10.projetoTesteEleicoes.dto.VotoDTO;
import com.abrito10.projetoTesteEleicoes.services.VotoService;

@RestController
@RequestMapping(value = "/votos")
public class VotoController {

	@Autowired
	private VotoService service;
	
	@RequestMapping(method = RequestMethod.GET)

	//@GetMapping
	public ResponseEntity<List<VotoDTO>> findAll(){
		List<VotoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(method = RequestMethod.POST)
//	@PostMapping
	public ResponseEntity<VotoDTO> insert(@RequestBody VotoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);

	}

}
