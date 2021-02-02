package com.abrito10.projetoTesteEleicoes.dto;

import java.io.Serializable;

import com.abrito10.projetoTesteEleicoes.entidades.Candidato;

public class CandidatoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
		
	private Long id;
	
 	private String nomeCandidato;
 	
 	private String imagemCandidato;
 	
	private String cargo;
	
	public CandidatoDTO() {		
	}

	public CandidatoDTO(Long id, String nomeCandidato, String imagemCandidato, String cargo) {
		this.id = id;
		this.nomeCandidato = nomeCandidato;
		this.imagemCandidato = imagemCandidato;		
		this.cargo = cargo;
	}

	public CandidatoDTO(Candidato entity) {
		id = entity.getId();
		nomeCandidato = entity.getNomeCandidato();
		imagemCandidato = entity.getImagemCandidato();
		cargo = entity.getCargo().getNomeCargo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCandidato() {
		return nomeCandidato;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public String getImagemCandidato() {
		return imagemCandidato;
	}

	public void setImagemCandidato(String imagemCandidato) {
		this.imagemCandidato = imagemCandidato;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
