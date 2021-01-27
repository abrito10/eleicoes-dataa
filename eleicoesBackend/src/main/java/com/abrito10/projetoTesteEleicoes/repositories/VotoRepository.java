package com.abrito10.projetoTesteEleicoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abrito10.projetoTesteEleicoes.entidades.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long>{
	
	List<Voto> findAllByOrderByCpfAsc();

}
