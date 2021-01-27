package com.abrito10.projetoTesteEleicoes.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.abrito10.projetoTesteEleicoes.entidades.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
		
	private Integer id;

	@NotEmpty(message = "Campo de Preenchimento Obrigatório")
	private String nomeUsuario;
	
 	@NotEmpty(message = "Campo de Preenchimento Obrigatório")
 	@CPF(message = "CPF Invalido")
	private String cpf;

 	@NotEmpty(message = "Campo de Preenchimento Obrigatório")
 	private String senha;
	

	public UsuarioDTO() {	
	}

	public UsuarioDTO(Integer id, String nomeUsuario, String cpf, String senha) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.cpf = cpf;
		this.senha = senha;
	}

	public UsuarioDTO(Usuario entity) {
		this.id = entity.getId();
		this.nomeUsuario = entity.getNomeUsuario();
		this.cpf = entity.getCpf();
		this.senha = entity.getSenha();
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
	
	
}
