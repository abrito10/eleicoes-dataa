package com.abrito10.projetoTesteEleicoes.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.abrito10.projetoTesteEleicoes.utils.GeraProtocolo;

@Entity
@Table(name = "tb_voto")
public class Voto  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private Long voto;
	private String protocolo;

	@ManyToMany
	@JoinTable(name = "tb_voto_candidato",
	joinColumns = @JoinColumn(name = "voto_id"),
	inverseJoinColumns = @JoinColumn(name = "candidato_id"))
	private Set<Candidato> candidatos = new HashSet<>();
	
	
	public Voto() {
	}
  
	public Voto(Long id, String cpf, Long voto, String protocolo) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.voto = voto;
		this.protocolo = GeraProtocolo.protocolo();
	}

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getVoto() {
		return voto;
	}

	public void setVoto(Long voto) {
		this.voto = voto;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	
	public Set<Candidato> getCandidatos() {
		return candidatos;
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
		Voto other = (Voto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
