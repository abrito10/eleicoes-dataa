package com.abrito10.projetoTesteEleicoes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abrito10.projetoTesteEleicoes.dto.CandidatoDTO;
import com.abrito10.projetoTesteEleicoes.entidades.Candidato;
import com.abrito10.projetoTesteEleicoes.repositories.CandidatoRepository;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository repository;
	
	@Transactional(readOnly = true) // para evitar lock de banco
	public List<CandidatoDTO> findAll() {
		List<Candidato> list = repository.findAllByOrderByNomeCandidatoAsc();
		return list.stream().map(x -> new CandidatoDTO(x)).collect(Collectors.toList());		
	}

	
	@Transactional
	public CandidatoDTO insert(CandidatoDTO dto) {
		Candidato candidato =  new Candidato(null, dto.getNomeCandidato(),dto.getImagemCandidato(), dto.getCargo());			
		candidato = repository.save(candidato);
		return new CandidatoDTO(candidato);
	}

}
