package com.abrito10.projetoTesteEleicoes.dto;

import java.io.Serializable;
import java.util.Date;

import com.abrito10.projetoTesteEleicoes.entidades.Eleicao;

public class EleicaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nomeEleicao;
 	
 	private Date dataInicio;

	private Date dataTermino;
	
	public EleicaoDTO() {
	}

	public EleicaoDTO(Long id, String nomeEleicao, Date dataInicio, Date dataTermino) {
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	
}
