package com.abrito10.projetoTesteEleicoes.dto;

import java.io.Serializable;

import com.abrito10.projetoTesteEleicoes.entidades.Cargo;

public class CargoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeCargo;
	
	public CargoDTO() {
	}

	public CargoDTO(Long id, String nomeCargo) {
		this.id = id;
		this.nomeCargo = nomeCargo;
	}
	
	public CargoDTO(Cargo entity) {
		id = entity.getId();
		nomeCargo = entity.getNomeCargo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	
	
	
}
