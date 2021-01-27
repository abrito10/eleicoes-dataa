package com.abrito10.projetoTesteEleicoes.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abrito10.projetoTesteEleicoes.dto.CargoDTO;
import com.abrito10.projetoTesteEleicoes.services.CargoService;

@RestController
@RequestMapping(value = "/cargos")
public class CargoController {

	@Autowired
	private CargoService service;
	
	@GetMapping
	public ResponseEntity<List<CargoDTO>> findAll(){
		List<CargoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping
	public ResponseEntity<CargoDTO> insert(@RequestBody CargoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);				
	}
}
