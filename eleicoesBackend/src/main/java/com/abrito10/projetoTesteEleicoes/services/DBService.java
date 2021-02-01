package com.abrito10.projetoTesteEleicoes.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.abrito10.projetoTesteEleicoes.entidades.Candidato;
import com.abrito10.projetoTesteEleicoes.entidades.Cargo;
import com.abrito10.projetoTesteEleicoes.entidades.Eleicao;
import com.abrito10.projetoTesteEleicoes.entidades.Usuario;
import com.abrito10.projetoTesteEleicoes.entidades.enums.Perfil;
import com.abrito10.projetoTesteEleicoes.repositories.CandidatoRepository;
import com.abrito10.projetoTesteEleicoes.repositories.CargoRepository;
import com.abrito10.projetoTesteEleicoes.repositories.EleicaoRepository;
import com.abrito10.projetoTesteEleicoes.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private CandidatoRepository candidatoRepository;

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private EleicaoRepository eleicaoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void instantiateDataBase() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Eleicao elei1 = new Eleicao(null,"Eleicao teste 1",sdf.parse("01/02/2021 10:32"), sdf.parse("03/02/2021 10:32")); 
		Eleicao elei2 = new Eleicao(null,"Eleicao teste 2",sdf.parse("01/02/2021 10:32"), sdf.parse("03/02/2021 10:32")); 
		eleicaoRepository.saveAll(Arrays.asList(elei1,elei2));

		Cargo car1 = new Cargo(null, "Presidente");
		Cargo car2 = new Cargo(null, "Governador");
		Cargo car3 = new Cargo(null, "Deputado");
		Cargo car4 = new Cargo(null, "Senador");
		Cargo car5 = new Cargo(null, "Vereador");
		Cargo car6 = new Cargo(null, "Secretario");
		cargoRepository.saveAll(Arrays.asList(car1, car2, car3, car4, car5, car6));

		Usuario user1 = new Usuario(null, "Usuario 1", "12345678909", "abrito10@gmail.com", pe.encode("12345")); 
		user1.addPerfil(Perfil.ADMIN);

		Usuario user2 = new Usuario(null, "Usuario 2", "12345678902", "abrito20@gmail.com", pe.encode("12345"));
		Usuario user3 = new Usuario(null, "Usuario 2", "12345678903", "abrito30@gmail.com", pe.encode("12345"));
		usuarioRepository.saveAll(Arrays.asList(user1,user2,user3));
	
		Candidato cand1 = new Candidato(null, "Adilson", "https://pt.wikipedia.org/wiki/Ficheiro:Canis_lupus_265b.jpg", "Deputado"); 
		Candidato cand2 = new Candidato(null, "Thays", "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_moda.jpg", "Deputado"); 
		Candidato cand3 = new Candidato(null, "Julia", "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_portuguesa.jpg", "Deputado"); 
		Candidato cand4 = new Candidato(null, "Raul", "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_carne.jpg", "Deputado"); 
		Candidato cand5 = new Candidato(null, "Osmar", "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_funghi.jpg", "Deputado"); 
		Candidato cand6 = new Candidato(null, "Renato", "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_espaguete.jpg", "Deputado"); 
		Candidato cand7 = new Candidato(null, "Cida", "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_fusili.jpg", "Deputado");
		Candidato cand8 = new Candidato(null, "Joao", "https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_penne.jpg", "Deputado");
		candidatoRepository.saveAll(Arrays.asList(cand1, cand2, cand3, cand4, cand5, cand6, cand7, cand8));
		
	}

}
