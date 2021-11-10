package com.games.vini.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.games.vini.entities.Usuario;
import com.games.vini.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvarUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
		
	}
	
	public List<Usuario> listarUsuario(){
		
		return usuarioRepository.findAll();
	}
	
	public Usuario obterUsuario(Long id) throws Exception{
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if(usuario.isEmpty()) {
			throw new Exception("Usuario não encontrado");
		}
		
		return usuario.get();
		
		
	}
	
	public void excluirUsuario(Long id) {
		
		usuarioRepository.deleteById(id);
		
	}

}
