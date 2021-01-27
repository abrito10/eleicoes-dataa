package com.abrito10.projetoTesteEleicoes.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abrito10.projetoTesteEleicoes.entidades.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>{
	
	List<Candidato> findAllByOrderByNomeCandidatoAsc();

}