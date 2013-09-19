package com.jnaldo.podoteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("participante")
public class ParticipanteController {

	@RequestMapping("")
	public String listarparticipantes(Model model) {

		model.addAttribute("message", "Lambda, lambda, lambda, Nerds!");

		return "participante/listar";
	}

	@RequestMapping("adicionar")
	public String adicionarparticipante(Model model) {
		model.addAttribute("acao", "Adicionar");
		return "participante/formulario";
	}

	@RequestMapping("editar")
	public String editarparticipante(Model model) {
		model.addAttribute("acao", "Editar");
		return "participante/formulario";
	}

	@RequestMapping("salvar")
	public String salvarparticipante() {
		return "redirect:";
	}

	@RequestMapping("remover")
	public String removerparticipante() {
		return "redirect:";
	}
}