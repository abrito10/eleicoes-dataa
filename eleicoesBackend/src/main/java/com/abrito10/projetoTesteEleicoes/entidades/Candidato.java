package com.abrito10.projetoTesteEleicoes.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_candidato")
public class Candidato  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCandidato;
	private String imagemCandidato;
	private String cargo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidato")
	private List<Voto> votos = new ArrayList<>();
	
	public Candidato() {
	}

	public Candidato(Long id, String nomeCandidato, String imagemCandidato, String cargo) {
		super();
		this.id = id;
		this.nomeCandidato = nomeCandidato;
		this.imagemCandidato = imagemCandidato;
		this.cargo = cargo;
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

	public Double getTotalVotos() {
		double sum = 0.00;
		for(Voto v: votos) {
			sum += 1;
		}
		return sum;
	}
	
	public List<Voto> getVotos() {
		return votos;
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
		Candidato other = (Candidato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}