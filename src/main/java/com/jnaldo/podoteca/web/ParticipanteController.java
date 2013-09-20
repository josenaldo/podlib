package com.jnaldo.podoteca.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jnaldo.podoteca.model.Participante;

@Controller
@RequestMapping("participantes")
public class ParticipanteController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView listarparticipantes(Model model) {

		ModelAndView mav = new ModelAndView();
		List<Participante> participantes = new ArrayList<Participante>();

		Participante participante1 = new Participante();
		participante1.setId(1l);
		participante1.setNome("Affonso Solano");
		participante1.setApelido("Solano");
		participante1.setEmail("solano@mrg.com.br");
		participante1.setTwitter("affonso_solano");

		Participante participante2 = new Participante();
		participante2.setId(2l);
		participante2.setNome("Roberto Duque Estrada");
		participante2.setApelido("Beto");
		participante2.setEmail("beto@mrg.com.br");
		participante2.setTwitter("betomrg");

		Participante participante3 = new Participante();
		participante3.setId(3l);
		participante3.setNome("Diogo Braga");
		participante3.setApelido("Didi Braguinha");
		participante3.setEmail("diogo@mrg.com.br");
		participante3.setTwitter("diogomrg");

		participantes.add(participante1);
		participantes.add(participante2);
		participantes.add(participante3);

		mav.setViewName("participante/listar");
		mav.addObject("participantes", participantes);

		return mav;
	}

	@RequestMapping("adicionar")
	public String adicionarParticipante(Model model) {

		model.addAttribute("participante", new Participante());

		return "participante/formulario";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String salvarParticipante(
			@Valid @ModelAttribute("participante") Participante participante,
			BindingResult result, RedirectAttributes attr, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Verifique os erros no formulário.");
			model.addAttribute("tipoDaMensagem", "danger");
			model.addAttribute("participante", participante);
			return "participante/formulario";
		} else {
			attr.addFlashAttribute("mensagem",
					"Participante " + participante.getNome()
							+ " adicionado com sucesso");
			attr.addFlashAttribute("tipoDaMensagem", "success");
			return "redirect:/participantes";
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String visualizarParticipante(@PathVariable("id") Long id,
			Model model) {

		Participante participante = new Participante();
		participante.setId(id);
		participante.setNome("Deive Pazos");
		participante.setApelido("Azaghal");
		participante.setEmail("deive@jovemnerd.com.br");
		participante.setTwitter("azaghal");

		model.addAttribute("participante", participante);

		return "participante/visualizar";
	}

	@RequestMapping("{id}/editar")
	public String editarParticipante(@PathVariable("id") Long id, Model model) {

		Participante participante = new Participante();
		participante.setId(id);
		participante.setNome("Deive Pazos");
		participante.setApelido("Azaghal");
		participante.setEmail("deive@jovemnerd.com.br");
		participante.setTwitter("azaghal");

		model.addAttribute("participante", participante);

		return "participante/formulario";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public String atualizarParticipante(@PathVariable("id") Long id,
			@Valid @ModelAttribute("participante") Participante participante,
			BindingResult result, RedirectAttributes attr, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Verifique os erros no formulário.");
			model.addAttribute("tipoDaMensagem", "danger");

			model.addAttribute("participante", participante);
			return "participante/formulario";
		} else {
			attr.addFlashAttribute("mensagem",
					"Participante " + participante.getNome()
							+ " editado com sucesso");
			attr.addFlashAttribute("tipoDaMensagem", "success");

			return "redirect:/participantes";
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String removerParticipante(@PathVariable("id") Long id,
			RedirectAttributes attr) {
		attr.addFlashAttribute("mensagem", "Participante apagado com sucesso");
		attr.addFlashAttribute("tipoDaMensagem", "info");

		return "redirect:/participantes";
	}
}