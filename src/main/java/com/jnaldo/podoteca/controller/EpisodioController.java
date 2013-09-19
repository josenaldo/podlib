package com.jnaldo.podoteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("episodio")
public class EpisodioController {

	@RequestMapping("")
	public String listarepisodios(Model model) {

		model.addAttribute("message", "Lambda, lambda, lambda, Nerds!");

		return "episodio/listar";
	}

	@RequestMapping("adicionar")
	public String adicionarepisodio(Model model) {
		model.addAttribute("acao", "Adicionar");
		return "episodio/formulario";
	}

	@RequestMapping("editar")
	public String editarepisodio(Model model) {
		model.addAttribute("acao", "Editar");
		return "episodio/formulario";
	}

	@RequestMapping("salvar")
	public String salvarepisodio() {
		return "redirect:";
	}

	@RequestMapping("remover")
	public String removerepisodio() {
		return "redirect:";
	}
}