package com.abrito10.projetoTesteEleicoes.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abrito10.projetoTesteEleicoes.dto.UsuarioDTO;
import com.abrito10.projetoTesteEleicoes.entidades.Usuario;
import com.abrito10.projetoTesteEleicoes.entidades.enums.Perfil;
import com.abrito10.projetoTesteEleicoes.repositories.UsuarioRepository;
import com.abrito10.projetoTesteEleicoes.security.UserSS;
import com.abrito10.projetoTesteEleicoes.services.exception.AuthorizationException;

import javassist.tools.rmi.ObjectNotFoundException;


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
		Usuario usuario =  new Usuario(dto.getId(), dto.getNomeUsuario(),dto.getCpf(), dto.getEmail(), pe.encode(dto.getSenha()));	
		usuario = repository.save(usuario);
		return new UsuarioDTO(usuario);
	}
	
	public Usuario find(Integer id) throws ObjectNotFoundException {
		UserSS user = UserService.authenticated();
		if(user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso Negado!!!");
		}
		Optional<Usuario> obj = repository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	public Usuario findByEmail(String email) throws ObjectNotFoundException {
		System.out.println("busca por email");

		Usuario obj = repository.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Email não encontrado! : " + email + ", Tipo: " + Usuario.class.getName());
		}
		return obj;
	}
}
