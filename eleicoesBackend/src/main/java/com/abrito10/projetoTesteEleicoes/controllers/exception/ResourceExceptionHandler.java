package com.abrito10.projetoTesteEleicoes.controllers.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abrito10.projetoTesteEleicoes.services.exception.AuthorizationException;



@ControllerAdvice
public class ResourceExceptionHandler {	

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request){
 		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), "Acesso negado", e.getMessage(), request.getRequestURI());
 		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
	
		
}
