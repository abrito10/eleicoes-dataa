package com.abrito10.projetoTesteEleicoes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abrito10.projetoTesteEleicoes.dto.UsuarioDTO;
import com.abrito10.projetoTesteEleicoes.entidades.Usuario;
import com.abrito10.projetoTesteEleicoes.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Transactional(readOnly = true) // para evitar lock de banco
	public List<UsuarioDTO> findAll() {
		List<Usuario> list = repository.findAllByOrderByNomeUsuarioAsc();
		//.findOrderWithProducts();
		return list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());		
	}
	
	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		Usuario usuario =  new Usuario(dto.getId(), dto.getNomeUsuario(),dto.getCpf(), pe.encode(dto.getSenha()));	
		usuario = repository.save(usuario);
		return new UsuarioDTO(usuario);
	}
}
