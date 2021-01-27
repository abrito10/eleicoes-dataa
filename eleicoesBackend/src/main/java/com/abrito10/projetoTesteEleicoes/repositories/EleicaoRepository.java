package com.abrito10.projetoTesteEleicoes.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abrito10.projetoTesteEleicoes.entidades.Eleicao;

public interface EleicaoRepository extends JpaRepository<Eleicao, Long>{
	
	List<Eleicao> findAllByOrderByNomeEleicaoAsc();

}