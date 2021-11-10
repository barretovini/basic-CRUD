package com.games.vini.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.games.vini.entities.Jogos;
import com.games.vini.services.JogosService;

@Controller
@RequestMapping("jogos")
public class JogosController {
	
	@Autowired
	private JogosService jogosService;
	
	@RequestMapping(path = "novo") // http://localhost:8080/jogos/novo
	public ModelAndView novoJogos() {
		
		ModelAndView mv = new ModelAndView("jogos/form.html");
		mv.addObject("jogos", new Jogos());
		
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.POST , path = "novo")
	public ModelAndView salvarJogos(@Valid Jogos jogos, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("jogos/form.html");
		
		boolean novo = true;
		
		if(jogos.getId()!=null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("jogos", jogos);
			return mv;
		}

		Jogos jogosSalvo = jogosService.salvarJogos(jogos);
		
		if(novo) {
			mv.addObject("jogos", new Jogos());
		}else {
			mv.addObject("jogos", jogosSalvo);
		}
		
		
		
		mv.addObject("mensagem", "Jogo salvo com sucesso");
		
		
		return mv;
		
	}
	
	@RequestMapping // http://localhost:8080/jogos
	public ModelAndView listarJogos() {
		
		ModelAndView mv = new ModelAndView("jogos/listar.html");
		mv.addObject("lista", jogosService.listarJogos());
		
		
		return mv;
		
	}
	
	@RequestMapping("/editar")
	public ModelAndView editarJogos(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("jogos/form.html");
		Jogos jogos;
		
		try {
			jogos = jogosService.obterJogos(id);
		}catch(Exception e) {
			jogos = new Jogos();
			mv.addObject("mensagem", e.getMessage());
		}
		
		mv.addObject("jogos", jogos);
		
		return mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirJogos(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/jogos");

		try {
			 jogosService.excluirJogos(id);
			 redirectAttributes.addFlashAttribute("mensagem", "Jogo excluído com sucesso.");
		}catch(Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir jogos!"+e.getMessage());
		}
				
		return mv;
	}
}

