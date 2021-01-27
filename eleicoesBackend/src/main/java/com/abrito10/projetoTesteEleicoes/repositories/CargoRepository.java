package com.abrito10.projetoTesteEleicoes.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abrito10.projetoTesteEleicoes.entidades.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long>{
	
	List<Cargo> findAllByOrderByNomeCargoAsc();

}