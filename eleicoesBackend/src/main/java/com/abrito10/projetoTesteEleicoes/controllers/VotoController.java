package com.abrito10.projetoTesteEleicoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abrito10.projetoTesteEleicoes.dto.VotoDTO;
import com.abrito10.projetoTesteEleicoes.services.VotoService;

@RestController
@RequestMapping(value = "/votos")
public class VotoController {

	@Autowired
	private VotoService service;
	
	@GetMapping
	public ResponseEntity<List<VotoDTO>> findAll(){
		List<VotoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
}
