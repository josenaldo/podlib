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
	public String adicionarepisodio() {

		return "episodio/adicionar";
	}

	@RequestMapping("editar")
	public String editarepisodio() {
		return "episodio/editar";
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