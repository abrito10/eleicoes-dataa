package com.abrito10.projetoTesteEleicoes.dto;

import java.io.Serializable;
import java.time.Instant;

import com.abrito10.projetoTesteEleicoes.entidades.Eleicao;

public class EleicaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nomeEleicao;
 	
 	private Instant dataInicio;

	private Instant dataTermino;
	
	public EleicaoDTO() {
	}

	public EleicaoDTO(Long id, String nomeEleicao, Instant dataInicio, Instant dataTermino) {
		this.id = id;
		this.nomeEleicao = nomeEleicao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}
	
	public EleicaoDTO(Eleicao entity) {
		id = entity.getId();
		nomeEleicao = entity.getNomeEleicao();
		dataInicio = entity.getDataInicio();
		dataTermino = entity.getDataTermino();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEleicao() {
		return nomeEleicao;
	}

	public void setNomeEleicao(String nomeEleicao) {
		this.nomeEleicao = nomeEleicao;
	}

	public Instant getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Instant dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Instant getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Instant dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	
}
