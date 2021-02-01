package com.abrito10.projetoTesteEleicoes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abrito10.projetoTesteEleicoes.entidades.Usuario;
import com.abrito10.projetoTesteEleicoes.repositories.UsuarioRepository;
import com.abrito10.projetoTesteEleicoes.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("chegou aqui userdatail");
		Usuario usr = repo.findByEmail(email);
		if(usr == null) {
			throw new UsernameNotFoundException(email);	
		}
		System.out.println("Email = " + usr.getEmail());
		System.out.println("Senha = " + usr.getSenha());
		
		return new UserSS(usr.getId(),usr.getEmail(),usr.getSenha(),usr.getPerfis());
	}

}