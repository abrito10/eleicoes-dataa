package com.abrito10.projetoTesteEleicoes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abrito10.projetoTesteEleicoes.dto.CandidatoDTO;
import com.abrito10.projetoTesteEleicoes.dto.VotoDTO;
import com.abrito10.projetoTesteEleicoes.entidades.Candidato;
import com.abrito10.projetoTesteEleicoes.entidades.Voto;
import com.abrito10.projetoTesteEleicoes.repositories.CandidatoRepository;
import com.abrito10.projetoTesteEleicoes.repositories.VotoRepository;

@Service
public class VotoService {
	
	@Autowired
	private VotoRepository repository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Transactional(readOnly = true) // para evitar lock de banco
	public List<VotoDTO> findAll() {
		List<Voto> list = repository.findVotoWithCandidato();
		return list.stream().map(x -> new VotoDTO(x)).collect(Collectors.toList());		
	}
	
	@Transactional
	public VotoDTO insert(VotoDTO dto) {
		Voto voto = new Voto(null,dto.getCpf(),dto.getVoto(),dto.getProtocolo());
		for(CandidatoDTO c : dto.getCandidatos()) {
			Candidato candidato = candidatoRepository.getOne(c.getId());
			voto.getCandidatos().add(candidato);
		}
		voto = repository.save(voto);
		return new VotoDTO(voto);
	}
	
}
