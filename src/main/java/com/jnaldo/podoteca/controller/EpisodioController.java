package com.jnaldo.podoteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("episodios")
public class EpisodioController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listarepisodios(Model model) {

		model.addAttribute("message", "Lambda, lambda, lambda, Nerds!");

		return "episodio/listar";
	}

	@RequestMapping("adicionar")
	public String adicionarEpisodio(Model model) {

		model.addAttribute("acao", "Adicionar");
		return "episodio/formulario";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String salvarEpisodio() {
		return "redirect:";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String mostraEpisodio() {
		return "episodio/visualizar";
	}

	@RequestMapping("/{id}/editar")
	public String editarEpisodio(Model model) {
		model.addAttribute("acao", "Editar");
		return "episodio/formulario";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String atualizarEpisodio() {
		return "redirect:";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String removerEpisodio() {
		return "redirect:";
	}
}