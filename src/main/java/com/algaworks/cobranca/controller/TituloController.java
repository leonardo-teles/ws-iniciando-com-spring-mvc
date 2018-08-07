package com.algaworks.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastroTitulo");
		mv.addObject("statusTitulo", StatusTitulo.values());
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> todosOsTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("pesquisaTitulo");
		mv.addObject("titulos", todosOsTitulos);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		titulos.save(titulo);
		
		ModelAndView mv = new ModelAndView("cadastroTitulo");
		mv.addObject("mensagem", "Título salvo com sucesso");
		
		return mv;
	}
	
	@ModelAttribute("statusTitulo")
	public List<StatusTitulo> statusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
}
