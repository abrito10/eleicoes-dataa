package com.abrito10.projetoTesteEleicoes.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.abrito10.projetoTesteEleicoes.entidades.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeUsuario;
	private String cpf;
	@JsonIgnore
	private String senha;
	

	@ElementCollection(fetch=FetchType.EAGER) // garantir que perfil seja carregado
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis =new HashSet<>();

	public Usuario() {	
		addPerfil(Perfil.VOTANTE); // todo usuario é um votante
	}


	public Usuario(Integer id, String nomeUsuario, String cpf, String senha) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.cpf = cpf;
		this.senha = senha;
 		addPerfil(Perfil.VOTANTE); // todo usuario é um votante
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis(){
 		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
