package com.abrito10.projetoTesteEleicoes.services;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abrito10.projetoTesteEleicoes.dto.VotoDTO;
import com.abrito10.projetoTesteEleicoes.entidades.Voto;
import com.abrito10.projetoTesteEleicoes.repositories.VotoRepository;

@Service
public class VotoService {
	
	@Autowired
	private VotoRepository repository;
	
	@Transactional(readOnly = true) // para evitar lock de banco
	public List<VotoDTO> findAll() {
		List<Voto> list = repository.findAllByOrderByCpfAsc();
		//.findOrderWithProducts();
		return list.stream().map(x -> new VotoDTO(x)).collect(Collectors.toList());
		
	}
	
}
