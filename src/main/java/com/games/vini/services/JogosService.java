package com.games.vini.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.games.vini.entities.Jogos;
import com.games.vini.repositories.JogosRepository;

@Service
public class JogosService {
	
	@Autowired
	private JogosRepository jogosRepository;
	
	public Jogos salvarJogos(Jogos jogos) {
		
		return jogosRepository.save(jogos);
		
	}
	
	public List<Jogos> listarJogos(){
		
		return jogosRepository.findAll();
		
	}
	
	public Jogos obterJogos(Long id) throws Exception {
		
		Optional<Jogos> jogos = jogosRepository.findById(id);
		
		if(jogos.isEmpty()) {
			throw new Exception("Jogo não encontrado.");
		}
		
		return jogos.get();
		
	}

	public void excluirJogos(Long id) {
		jogosRepository.deleteById(id);
	}

}