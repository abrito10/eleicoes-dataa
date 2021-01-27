package com.abrito10.projetoTesteEleicoes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abrito10.projetoTesteEleicoes.dto.EleicaoDTO;
import com.abrito10.projetoTesteEleicoes.entidades.Eleicao;
import com.abrito10.projetoTesteEleicoes.repositories.EleicaoRepository;

@Service
public class EleicaoService {
	
	@Autowired
	private EleicaoRepository repository;
	
	@Transactional(readOnly = true) // para evitar lock de banco
	public List<EleicaoDTO> findAll() {
		List<Eleicao> list = repository.findAllByOrderByNomeEleicaoAsc();
		return list.stream().map(x -> new EleicaoDTO(x)).collect(Collectors.toList());		
	}
	
	@Transactional
	public EleicaoDTO insert(EleicaoDTO dto) {
		Eleicao cargo = new Eleicao(null, dto.getNomeEleicao(), dto.getDataInicio(), dto.getDataTermino());	
		cargo = repository.save(cargo);
		return new EleicaoDTO(cargo);
	}
	
}
