package com.jnaldo.podoteca.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jnaldo.podoteca.model.Participante;
import com.jnaldo.podoteca.services.ParticipanteService;
import com.jnaldo.podoteca.util.message.Alerta;
import com.jnaldo.podoteca.web.exception.WebException;

@Controller
@RequestMapping("participantes")
public class ParticipanteController {

	@Autowired
	private ParticipanteService participanteService;

	@Autowired
	private Alerta alerta;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView listarParticipantes(ModelAndView modelAndView) {

		List<Participante> participantes = this.participanteService.findAll();

		modelAndView.setViewName("participante/listar");
		modelAndView.addObject("participantes", participantes);

		return modelAndView;
	}

	@RequestMapping("adicionar")
	public ModelAndView adicionarParticipante(ModelAndView modelAndView) {

		modelAndView.addObject("participante", new Participante());

		modelAndView.setViewName("participante/formulario");

		return modelAndView;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView salvarParticipante(
			@Valid @ModelAttribute("participante") Participante participante,
			BindingResult result, RedirectAttributes attr,
			ModelAndView modelAndView) {

		return this.saveParticipante(participante, result, attr, modelAndView);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView visualizarParticipante(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Participante participante = this.participanteService.find(id);

		if (participante == null) {
			throw new WebException(Alerta.PARTICIPANTE_NAO_ENCONTRADO);
		} else {
			modelAndView.addObject("participante", participante);
			modelAndView.setViewName("participante/visualizar");
		}

		return modelAndView;
	}

	@RequestMapping("{id}/editar")
	public ModelAndView editarParticipante(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Participante participante = this.participanteService.find(id);

		if (participante == null) {
			throw new WebException(Alerta.PARTICIPANTE_NAO_ENCONTRADO);
		} else {
			modelAndView.addObject("participante", participante);
			modelAndView.setViewName("participante/formulario");
		}

		return modelAndView;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ModelAndView atualizarParticipante(@PathVariable("id") Long id,
			@Valid @ModelAttribute("participante") Participante participante,
			BindingResult result, RedirectAttributes attr,
			ModelAndView modelAndView) {

		return this.saveParticipante(participante, result, attr, modelAndView);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ModelAndView removerParticipante(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Participante participante = this.participanteService.find(id);

		if (participante == null) {
			throw new WebException(Alerta.PARTICIPANTE_NAO_ENCONTRADO);
		} else {
			this.participanteService.delete(id);

			this.alerta.sucesso(attr, Alerta.PARTICIPANTE_APAGADO);

		}
		modelAndView.setViewName("redirect:/participantes");

		return modelAndView;

	}

	private ModelAndView saveParticipante(Participante participante,
			BindingResult result, RedirectAttributes attr,
			ModelAndView modelAndView) {

		if (result.hasErrors()) {

			this.alerta.erro(modelAndView, Alerta.ERROS_NO_FORMULARIO);

			modelAndView.addObject("participante", participante);
			modelAndView.setViewName("participante/formulario");
		} else {

			this.participanteService.save(participante);

			this.alerta.sucesso(attr, Alerta.PARTICIPANTE_SALVO);

			modelAndView.setViewName("redirect:/participantes");
		}

		return modelAndView;
	}
}