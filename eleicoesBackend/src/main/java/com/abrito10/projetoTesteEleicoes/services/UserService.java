package com.abrito10.projetoTesteEleicoes.services;


import org.springframework.security.core.context.SecurityContextHolder;

import com.abrito10.projetoTesteEleicoes.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();			
		}
		catch (Exception e) {
			return null;
		}
	}
}
