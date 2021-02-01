package com.abrito10.projetoTesteEleicoes.utils;

import java.util.Random;

public class GeraProtocolo {

	private static Random rand = new Random();	
	
	public static String protocolo() {	
		String p = GeraProtocolo();
		return p;
	}
	
	public static String GeraProtocolo() {
		char[] vet = new char[16];
		int cont=0;
		for(int i=0; i<16; i++) {
			vet[i] = randomChar();
			cont++;
			if(cont == 5) {
				vet[i] = traco();
				//i++;
				cont=0;
			}
		}
		return new String(vet);
	}
	
	private static char randomChar() {
		int opt = rand.nextInt(3);
		if(opt == 0) { // gera um digito
			return(char) (rand.nextInt(10) + 48);
		} 
		else if(opt == 1) { // gera uma letra maiuscula
			return(char) (rand.nextInt(26) + 65);			
		}
		else { // gera uma letra minuscula
			return(char) (rand.nextInt(26) + 97);					
		}	
	}

	private static char traco() {
		return(char) (45);					

	}

}
