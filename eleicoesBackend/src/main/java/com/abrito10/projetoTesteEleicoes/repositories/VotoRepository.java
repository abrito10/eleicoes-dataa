package com.abrito10.projetoTesteEleicoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abrito10.projetoTesteEleicoes.entidades.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long>{
	
	List<Voto> findAllByOrderByCpfAsc();
	
	@Query("Select distinct obj from Voto obj join fetch obj.candidatos "  
						+ " order by obj.cpf ASC")	
	List<Voto> findVotoWithCandidato();
	
}
