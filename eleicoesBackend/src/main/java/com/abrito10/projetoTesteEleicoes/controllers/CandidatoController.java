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

import com.abrito10.projetoTesteEleicoes.dto.CandidatoDTO;
import com.abrito10.projetoTesteEleicoes.services.CandidatoService;

@RestController
@RequestMapping(value = "/candidatos")
public class CandidatoController {

	@Autowired
	private CandidatoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	//@GetMapping
	public ResponseEntity<List<CandidatoDTO>> findAll(){
		List<CandidatoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
		@RequestMapping(method = RequestMethod.POST)
		//@PostMapping
		public ResponseEntity<CandidatoDTO> insert(@RequestBody CandidatoDTO dto){
			dto = service.insert(dto);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);				
		}
}
