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

import com.jnaldo.podoteca.model.Episodio;
import com.jnaldo.podoteca.model.Participante;
import com.jnaldo.podoteca.model.Podcast;
import com.jnaldo.podoteca.services.EpisodioService;
import com.jnaldo.podoteca.services.ParticipanteService;
import com.jnaldo.podoteca.services.PodcastService;
import com.jnaldo.podoteca.util.message.Alerta;
import com.jnaldo.podoteca.web.exception.WebException;

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
	public ModelAndView listarEpisodios(ModelAndView modelAndView) {

		List<Episodio> episodios = this.episodioService.findAll();

		modelAndView.setViewName("episodio/listar");
		modelAndView.addObject("episodios", episodios);

		return modelAndView;
	}

	@RequestMapping("adicionar")
	public ModelAndView adicionarEpisodio(
			@RequestParam(value = "podcastId", required = false) Long podcastId,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Episodio episodio = new Episodio();

		List<Podcast> podcasts = this.buscarPodcasts();

		Podcast podcastSelecionado = this.buscarPodcastSelecionado(podcastId);

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
			ModelAndView modelAndView) throws WebException {

		return this.salvar(episodio, result, attr, modelAndView);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView visualizarEpisodio(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Episodio episodio = this.episodioService.find(id);

		if (episodio == null) {
			throw new WebException(Alerta.EPISODIO_NAO_ENCONTRADO);
		} else {
			modelAndView.addObject("episodio", episodio);
			modelAndView.setViewName("episodio/visualizar");
		}

		return modelAndView;
	}

	@RequestMapping("{id}/editar")
	public ModelAndView editarEpisodio(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Episodio episodio = this.episodioService.find(id);

		List<Podcast> podcasts = this.buscarPodcasts();

		if (episodio == null) {
			throw new WebException(Alerta.EPISODIO_NAO_ENCONTRADO);
		} else {
			modelAndView.addObject("podcasts", podcasts);
			modelAndView.addObject("episodio", episodio);
			modelAndView.setViewName("episodio/formulario");
		}

		return modelAndView;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ModelAndView atualizarEpisodio(@PathVariable("id") Long id,
			@Valid @ModelAttribute("episodio") Episodio episodio,
			BindingResult result, RedirectAttributes attr,
			ModelAndView modelAndView) throws WebException {

		return this.salvar(episodio, result, attr, modelAndView);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ModelAndView removerEpisodio(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Episodio episodio = this.episodioService.find(id);

		if (episodio == null) {
			throw new WebException(Alerta.EPISODIO_NAO_ENCONTRADO);
		} else {
			this.episodioService.delete(id);

			this.alerta.sucesso(attr, Alerta.EPISODIO_APAGADO);

		}
		modelAndView.setViewName("redirect:/episodios");

		return modelAndView;

	}

	private ModelAndView salvar(Episodio episodio, BindingResult result,
			RedirectAttributes redirectAttributes, ModelAndView modelAndView)
			throws WebException {

		if (result.hasErrors()) {

			this.alerta.erro(modelAndView, Alerta.ERROS_NO_FORMULARIO);

			List<Podcast> podcasts = this.buscarPodcasts();

			modelAndView.addObject("podcasts", podcasts);
			modelAndView.addObject("episodio", episodio);
			modelAndView.setViewName("episodio/formulario");
		} else {

			this.episodioService.save(episodio);

			this.alerta.sucesso(redirectAttributes, Alerta.EPISODIO_SALVO);

			modelAndView.setViewName("redirect:/episodios");
		}

		return modelAndView;
	}

	@RequestMapping(value = "adicionar-remover-participantes/{id}", method = RequestMethod.GET)
	public ModelAndView adicionarParticipantes(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		EpisodioParticipantesForm episodioParticipanteForm = new EpisodioParticipantesForm();
		List<Participante> participantes = this.buscarParticipantes();
		List<Episodio> episodios = this.buscarEpisodios();

		Episodio episodio = this.buscarEpisodioSelecionado(id);
		episodioParticipanteForm.setEpisodio(episodio);

		modelAndView.addObject("participantes", participantes);
		modelAndView.addObject("episodios", episodios);
		modelAndView.addObject("episodioParticipantesForm",
				episodioParticipanteForm);
		modelAndView.setViewName("episodio/formulario_participantes");

		return modelAndView;
	}

	@RequestMapping(value = "adicionar-remover-participantes", method = RequestMethod.POST)
	public ModelAndView salvarParticipantes() throws WebException {

		throw new WebException("Método não implementado");

	}

	private List<Podcast> buscarPodcasts() throws WebException {
		List<Podcast> podcasts = this.podcastService.findAll();

		if (podcasts.isEmpty()) {
			throw new WebException(Alerta.PODCAST_LISTA_VAZIA);
		}

		return podcasts;
	}

	private List<Episodio> buscarEpisodios() throws WebException {
		List<Episodio> episodios = this.episodioService.findAll();

		if (episodios.isEmpty()) {
			throw new WebException(Alerta.EPISODIO_LISTA_VAZIA);
		}

		return episodios;
	}

	private List<Participante> buscarParticipantes() throws WebException {
		List<Participante> participantes = this.participanteService.findAll();

		if (participantes.isEmpty()) {
			throw new WebException(Alerta.PARTICIPANTE_LISTA_VAZIA);
		}

		return participantes;
	}

	private Podcast buscarPodcastSelecionado(Long podcastId)
			throws WebException {
		if (podcastId == null) {
			return null;
		}

		Podcast podcast = this.podcastService.find(podcastId);

		if (podcast == null) {
			throw new WebException(Alerta.PODCAST_NAO_ENCONTRADO);
		}

		return podcast;
	}

	private Episodio buscarEpisodioSelecionado(Long episodioId)
			throws WebException {
		if (episodioId == null) {
			return null;
		}

		Episodio episodio = this.episodioService.find(episodioId);

		if (episodio == null) {
			throw new WebException(Alerta.EPISODIO_NAO_ENCONTRADO);
		}

		return episodio;

	}

}