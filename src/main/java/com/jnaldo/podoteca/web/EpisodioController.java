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
import com.jnaldo.podoteca.model.Podcast;
import com.jnaldo.podoteca.services.EpisodioService;
import com.jnaldo.podoteca.services.PodcastService;
import com.jnaldo.podoteca.util.message.MessageUtils;
import com.jnaldo.podoteca.util.message.NivelDoAlerta;
import com.jnaldo.podoteca.web.exception.WebException;

@Controller
@RequestMapping("episodios")
public class EpisodioController {

	@Autowired
	private EpisodioService episodioService;

	@Autowired
	private PodcastService podcastService;

	@Autowired
	private MessageUtils messageUtils;

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

		return this.saveEpisodio(episodio, result, attr, modelAndView);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView visualizarEpisodio(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Episodio episodio = this.episodioService.find(id);

		if (episodio == null) {
			throw new WebException("Episodio não encontrado.");
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
			throw new WebException("Episodio não encontrado.");
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

		return this.saveEpisodio(episodio, result, attr, modelAndView);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ModelAndView removerEpisodio(@PathVariable("id") Long id,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		Episodio episodio = this.episodioService.find(id);

		if (episodio == null) {
			throw new WebException("Episodio não encontrado.");
		} else {
			this.episodioService.delete(id);

			this.messageUtils.mensagem(attr, "Episodio apagado com sucesso",
					NivelDoAlerta.SUCCESS);

		}
		modelAndView.setViewName("redirect:/episodios");

		return modelAndView;

	}

	private ModelAndView saveEpisodio(Episodio episodio, BindingResult result,
			RedirectAttributes attr, ModelAndView modelAndView)
			throws WebException {

		if (result.hasErrors()) {

			this.messageUtils.mensagem(modelAndView,
					"Verifique os erros no formulário.", NivelDoAlerta.DANGER);

			List<Podcast> podcasts = this.buscarPodcasts();

			modelAndView.addObject("podcasts", podcasts);
			modelAndView.addObject("episodio", episodio);
			modelAndView.setViewName("episodio/formulario");
		} else {

			this.episodioService.save(episodio);

			this.messageUtils.mensagem(attr, "Episodio " + episodio.getTitulo()
					+ " adicionado com sucesso", NivelDoAlerta.SUCCESS);

			modelAndView.setViewName("redirect:/episodios");
		}

		return modelAndView;
	}

	private Podcast buscarPodcastSelecionado(Long podcastId)
			throws WebException {
		if (podcastId == null) {
			return null;
		}

		Podcast podcast = this.podcastService.find(podcastId);

		if (podcast == null) {
			throw new WebException("Podcast informado não foi encontrado");
		}

		return podcast;
	}

	private List<Podcast> buscarPodcasts() throws WebException {
		List<Podcast> podcasts = this.podcastService.findAll();

		if (podcasts.isEmpty()) {
			throw new WebException("Nenhum podcast foi cadastrado");
		}

		return podcasts;
	}

}