package com.jnaldo.podoteca.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jnaldo.podoteca.model.Episodio;

@Controller
@RequestMapping("episodios")
public class EpisodioController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listarepisodios(Model model) {

		return "episodio/listar";
	}

	@RequestMapping("adicionar")
	public String adicionarEpisodio(Model model) {

		model.addAttribute("acao", "Adicionar");
		return "episodio/formulario";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String salvarEpisodio(@ModelAttribute("episodio") Episodio episodio,
			RedirectAttributes attr) {

		attr.addFlashAttribute("mensagem", "Episódio " + episodio.getTitulo()
				+ " adicionado com sucesso");
		attr.addFlashAttribute("tipoDaMensagem", "success");
		return "redirect:/episodios";
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
		return "redirect:/episodios";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String removerEpisodio() {
		return "redirect:/episodios";
	}
}