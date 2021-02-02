package com.abrito10.projetoTesteEleicoes.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.abrito10.projetoTesteEleicoes.entidades.Voto;

public class VotoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cpf;
	private Long voto;
	private String protocolo;
	
	private List<CandidatoDTO> candidatos = new ArrayList<>();
	
	public VotoDTO() {		
	}

	public VotoDTO(Long id, String cpf, Long voto, String protocolo) {
		this.id = id;
		this.cpf = cpf;
		this.voto = voto;
		this.protocolo = protocolo;
	}
	
	public VotoDTO(Voto entity) {
		id = entity.getid();
		cpf = entity.getCpf();
		voto = entity.getVoto();
		protocolo = entity.getProtocolo();
		candidatos = entity.getCandidatos().stream().map(x -> new CandidatoDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public List<CandidatoDTO> getCandidatos() {
		return candidatos;
	}

}
