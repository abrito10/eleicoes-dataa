package com.abrito10.projetoTesteEleicoes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abrito10.projetoTesteEleicoes.dto.CargoDTO;
import com.abrito10.projetoTesteEleicoes.entidades.Cargo;
import com.abrito10.projetoTesteEleicoes.repositories.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository repository;
	
	@Transactional(readOnly = true)
	public List<CargoDTO> findAll() {
		List<Cargo> list = repository.findAllByOrderByNomeCargoAsc();
		return list.stream().map(x -> new CargoDTO(x)).collect(Collectors.toList());		
	}
	
	@Transactional
	public CargoDTO insert(CargoDTO dto) {
		Cargo cargo = new Cargo(null, dto.getNomeCargo());	
		cargo = repository.save(cargo);
		return new CargoDTO(cargo);
	}

}
