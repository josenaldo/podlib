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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jnaldo.podoteca.business.exceptions.BusinessException;
import com.jnaldo.podoteca.business.services.EpisodioService;
import com.jnaldo.podoteca.business.services.ParticipanteService;
import com.jnaldo.podoteca.business.services.PodcastService;
import com.jnaldo.podoteca.model.Episodio;
import com.jnaldo.podoteca.model.Participante;
import com.jnaldo.podoteca.model.Podcast;
import com.jnaldo.podoteca.util.message.Alerta;
import com.jnaldo.podoteca.util.message.Messages;

@Controller
@RequestMapping("episodios")
public class EpisodioController {

	@Autowired
	private EpisodioService episodioService;

	@Autowired
	private PodcastService podcastService;

	@Autowired
	private ParticipanteService participanteService;

	@Autowired
	private Alerta alerta;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView listarEpisodios(ModelAndView modelAndView)
			throws BusinessException {

		List<Episodio> episodios = this.episodioService.findAll();

		modelAndView.setViewName("episodio/listar");
		modelAndView.addObject("episodios", episodios);

		return modelAndView;
	}

	@RequestMapping("adicionar")
	public ModelAndView adicionarEpisodio(
			@RequestParam(value = "podcastId", required = false) Long podcastId,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws BusinessException {

		Episodio episodio = new Episodio();
		Podcast podcastSelecionado = null;

		List<Podcast> podcasts = this.podcastService.findAll();

		if (podcastId != null) {
			podcastSelecionado = this.podcastService.find(podcastId);
		}

		episodio.setPodcast(podcastSelecionado);

		modelAndView.addObject("podcasts", podcasts);
		modelAndView.addObject("episodio", episodio);
		modelAndView.setViewName("episodio/formulario");

		return modelAndView;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView salvarEpisodio(
			@Valid @ModelAttribute("episodio") Episodio episodio,
			BindingResult result, RedirectAttributes attr,
			ModelAndView modelAndView) throws BusinessException {

		return this.salvar(episodio, result, attr, modelAndView);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView visualizarEpisodio(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws BusinessException {

		Episodio episodio = this.episodioService
				.findEpisodioWithParticipantes(id);

		modelAndView.addObject("episodio", episodio);
		modelAndView.setViewName("episodio/visualizar");

		return modelAndView;
	}

	@RequestMapping("{id}/editar")
	public ModelAndView editarEpisodio(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws BusinessException {

		Episodio episodio = this.episodioService.find(id);

		List<Podcast> podcasts = this.podcastService.findAll();

		modelAndView.addObject("podcasts", podcasts);
		modelAndView.addObject("episodio", episodio);
		modelAndView.setViewName("episodio/formulario");

		return modelAndView;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ModelAndView atualizarEpisodio(@PathVariable("id") Long id,
			@Valid @ModelAttribute("episodio") Episodio episodio,
			BindingResult result, RedirectAttributes attr,
			ModelAndView modelAndView) throws BusinessException {

		return this.salvar(episodio, result, attr, modelAndView);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ModelAndView removerEpisodio(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws BusinessException {

		this.episodioService.find(id);

		this.episodioService.delete(id);

		this.alerta.sucesso(attr, Messages.EPISODIO_APAGADO);

		modelAndView.setViewName("redirect:/episodios");

		return modelAndView;

	}

	private ModelAndView salvar(Episodio episodio, BindingResult result,
			RedirectAttributes redirectAttributes, ModelAndView modelAndView)
			throws BusinessException {

		if (result.hasErrors()) {

			this.alerta.erro(modelAndView, Messages.ERROS_NO_FORMULARIO);

			List<Podcast> podcasts = this.podcastService.findAll();

			modelAndView.addObject("podcasts", podcasts);
			modelAndView.addObject("episodio", episodio);
			modelAndView.setViewName("episodio/formulario");
		} else {

			this.episodioService.save(episodio);

			this.alerta.sucesso(redirectAttributes, Messages.EPISODIO_SALVO);

			modelAndView.setViewName("redirect:/episodios");
		}

		return modelAndView;
	}

	@RequestMapping(value = "adicionar-remover-participantes/{id}", method = RequestMethod.GET)
	public ModelAndView adicionarParticipantes(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws BusinessException {

		EpisodioParticipantesForm episodioParticipantesForm = new EpisodioParticipantesForm();
		List<Participante> listaDeParticipantes = this.participanteService
				.findAll();

		Episodio episodio = this.episodioService
				.findEpisodioWithParticipantes(id);

		episodioParticipantesForm.setParticipantes(episodio.getParticipantes());
		episodioParticipantesForm.setId(id);
		episodioParticipantesForm.setTitulo(episodio.getTitulo());

		modelAndView.addObject("listaDeParticipantes", listaDeParticipantes);
		modelAndView.addObject("episodioParticipantesForm",
				episodioParticipantesForm);
		modelAndView.setViewName("episodio/formulario_participantes");

		return modelAndView;
	}

	@RequestMapping(value = "adicionar-remover-participantes/{id}", method = RequestMethod.POST)
	public ModelAndView salvarParticipantes(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("episodioParticipantesForm") EpisodioParticipantesForm episodioParticipantesForm,
			BindingResult result, RedirectAttributes redirectAttributes,
			ModelAndView modelAndView) throws BusinessException {

		if (result.hasErrors()) {

			this.alerta.erro(modelAndView, Messages.ERROS_NO_FORMULARIO);

			List<Participante> listaDeParticipantes = this.participanteService
					.findAll();

			List<Episodio> episodios = this.episodioService.findAll();

			Episodio episodio = this.episodioService.find(id);

			episodioParticipantesForm.setParticipantes(episodio
					.getParticipantes());
			episodioParticipantesForm.setId(id);
			episodioParticipantesForm.setTitulo(episodio.getTitulo());

			modelAndView
					.addObject("listaDeParticipantes", listaDeParticipantes);
			modelAndView.addObject("episodios", episodios);
			modelAndView.addObject("episodioParticipantesForm",
					episodioParticipantesForm);

			modelAndView.setViewName("episodio/formulario_participantes");
		} else {

			Episodio episodio = this.episodioService
					.find(episodioParticipantesForm.getId());
			List<Participante> participantes = episodioParticipantesForm
					.getParticipantes();

			episodio.setParticipantes(participantes);

			this.episodioService.save(episodio);

			this.alerta.sucesso(redirectAttributes, Messages.EPISODIO_SALVO);

			modelAndView.setViewName("redirect:/episodios");
		}

		return modelAndView;

	}

}