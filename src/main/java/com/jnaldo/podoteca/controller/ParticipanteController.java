package com.jnaldo.podoteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("participantes")
public class ParticipanteController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listarparticipantes(Model model) {

		model.addAttribute("message", "Lambda, lambda, lambda, Nerds!");

		return "participante/listar";
	}

	@RequestMapping("adicionar")
	public String adicionarParticipante(Model model) {

		model.addAttribute("acao", "Adicionar");
		return "participante/formulario";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String salvarParticipante() {
		return "redirect:";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String mostraParticipante() {
		return "participante/visualizar";
	}

	@RequestMapping("/{id}/editar")
	public String editarParticipante(Model model) {
		model.addAttribute("acao", "Editar");
		return "participante/formulario";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String atualizarParticipante() {
		return "redirect:";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String removerParticipante() {
		return "redirect:";
	}
}