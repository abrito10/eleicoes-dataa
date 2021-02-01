package com.abrito10.projetoTesteEleicoes.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_eleicao")
public class Eleicao  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeEleicao;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataInicio;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataTermino;
	
	public Eleicao() {
	}

	public Eleicao(Long id, String nomeEleicao, Date dataInicio, Date dataTermino) {
		super();
		this.id = id;
		this.nomeEleicao = nomeEleicao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eleicao other = (Eleicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
