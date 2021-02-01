package com.abrito10.projetoTesteEleicoes.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abrito10.projetoTesteEleicoes.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
	Usuario findByEmail(String email);
	
	List<Usuario> findAllByOrderByNomeUsuarioAsc();

	}