package com.jnaldo.podoteca.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jnaldo.podoteca.model.Participante;

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
	public String salvarParticipante(
			@ModelAttribute("participante") Participante participante,
			RedirectAttributes attr) {

		attr.addFlashAttribute("mensagem",
				"Participante " + participante.getNome()
						+ " adicionado com sucesso");
		attr.addFlashAttribute("tipoDaMensagem", "success");

		return "redirect:/participantes";
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
		return "redirect:/participantes";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String removerParticipante() {
		return "redirect:/participantes";
	}
}