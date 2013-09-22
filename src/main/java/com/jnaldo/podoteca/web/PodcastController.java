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

import com.jnaldo.podoteca.model.Podcast;
import com.jnaldo.podoteca.services.PodcastService;
import com.jnaldo.podoteca.util.message.Alerta;
import com.jnaldo.podoteca.web.exception.WebException;

@Controller
@RequestMapping("podcasts")
public class PodcastController {

	@Autowired
	private PodcastService podcastService;

	@Autowired
	private Alerta alerta;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView listarPodcasts(ModelAndView modelAndView) {

		List<Podcast> podcasts = this.podcastService.findAll();

		modelAndView.setViewName("podcast/listar");
		modelAndView.addObject("podcasts", podcasts);

		return modelAndView;
	}

	@RequestMapping("adicionar")
	public ModelAndView adicionarPodcast(ModelAndView modelAndView) {

		modelAndView.addObject("podcast", new Podcast());

		modelAndView.setViewName("podcast/formulario");

		return modelAndView;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView salvarPodcast(
			@Valid @ModelAttribute("podcast") Podcast podcast,
			BindingResult result, RedirectAttributes attr,
			ModelAndView modelAndView) {

		return this.savePodcast(podcast, result, attr, modelAndView);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView visualizarPodcast(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Podcast podcast = this.podcastService.find(id);

		if (podcast == null) {
			throw new WebException(Alerta.PODCAST_NAO_ENCONTRADO);
		} else {
			modelAndView.addObject("podcast", podcast);
			modelAndView.setViewName("podcast/visualizar");
		}

		return modelAndView;
	}

	@RequestMapping("{id}/editar")
	public ModelAndView editarPodcast(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Podcast podcast = this.podcastService.find(id);

		if (podcast == null) {
			throw new WebException(Alerta.PODCAST_NAO_ENCONTRADO);
		} else {
			modelAndView.addObject("podcast", podcast);
			modelAndView.setViewName("podcast/formulario");
		}

		return modelAndView;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ModelAndView atualizarPodcast(@PathVariable("id") Long id,
			@Valid @ModelAttribute("podcast") Podcast podcast,
			BindingResult result, RedirectAttributes attr,
			ModelAndView modelAndView) {

		return this.savePodcast(podcast, result, attr, modelAndView);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ModelAndView removerPodcast(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Podcast podcast = this.podcastService.find(id);

		if (podcast == null) {
			throw new WebException(Alerta.PODCAST_NAO_ENCONTRADO);
		} else {
			this.podcastService.delete(id);

			this.alerta.sucesso(attr, Alerta.PODCAST_APAGADO);

		}
		modelAndView.setViewName("redirect:/podcasts");

		return modelAndView;

	}

	private ModelAndView savePodcast(Podcast podcast, BindingResult result,
			RedirectAttributes attr, ModelAndView modelAndView) {

		if (result.hasErrors()) {

			this.alerta.erro(modelAndView, Alerta.ERROS_NO_FORMULARIO);

			modelAndView.addObject("podcast", podcast);
			modelAndView.setViewName("podcast/formulario");
		} else {

			this.podcastService.save(podcast);

			this.alerta.sucesso(attr, Alerta.PODCAST_SALVO);

			modelAndView.setViewName("redirect:/podcasts");
		}

		return modelAndView;
	}
}