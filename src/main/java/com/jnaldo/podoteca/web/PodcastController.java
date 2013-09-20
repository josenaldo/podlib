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

import com.jnaldo.podoteca.model.Podcast;

@Controller
@RequestMapping("podcasts")
public class PodcastController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView listarPodcasts() {
		ModelAndView mav = new ModelAndView();
		List<Podcast> podcasts = new ArrayList<Podcast>();

		Podcast podcast1 = new Podcast();
		podcast1.setId(1L);
		podcast1.setNome("Nerdcast");
		podcast1.setDescricao("Nerdcast é o primeiro podcast totalmente nerd do Brasil. É um papo bastante informal entre os criadores do site e convidados sobre os mais derivados assuntos do mundo nerd.");
		podcast1.setSite("http://jovemnerd.ig.com.br/nerdcast/");

		Podcast podcast2 = new Podcast();
		podcast2.setId(2L);
		podcast2.setNome("Matando Robôs Gigantes");
		podcast2.setDescricao("O Matando Robôs Gigantes é um Podcast de humor dividido em quatro episódios: Cinema, Games, Quadrinhos e a Voz do Robô.");
		podcast2.setSite("http://jovemnerd.ig.com.br/matando-robos-gigantes/");

		Podcast podcast3 = new Podcast();
		podcast3.setId(3L);
		podcast3.setNome("99 Vidas");
		podcast3.setDescricao("O 99Vidas é um site que publica semanalmente podcasts sobre temas que marcaram a infância e adolescência de todos os amantes de videogames.");
		podcast3.setSite("http://99vidas.com.br/");

		podcasts.add(podcast1);
		podcasts.add(podcast2);
		podcasts.add(podcast3);

		mav.setViewName("podcast/listar");
		mav.addObject("podcasts", podcasts);

		return mav;
	}

	@RequestMapping("adicionar")
	public String adicionarPodcast(Model model) {

		model.addAttribute("podcast", new Podcast());

		return "podcast/formulario";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String salvarPodcast(
			@Valid @ModelAttribute("podcast") Podcast podcast,
			BindingResult result, RedirectAttributes attr, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Verifique os erros no formulário.");
			model.addAttribute("tipoDaMensagem", "danger");
			model.addAttribute("podcast", podcast);
			return "podcast/formulario";
		} else {
			attr.addFlashAttribute("mensagem", "Podcast " + podcast.getNome()
					+ " adicionado com sucesso");
			attr.addFlashAttribute("tipoDaMensagem", "success");
			return "redirect:/podcasts";
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String visualizarPodcast(@PathVariable("id") Long id, Model model) {

		Podcast podcast = new Podcast();
		podcast.setId(id);
		podcast.setNome("Teste");
		podcast.setDescricao("Teste de descrição");
		podcast.setSite("http://www.podcast.com");
		model.addAttribute("podcast", podcast);

		return "podcast/visualizar";
	}

	@RequestMapping("{id}/editar")
	public String editarPodcast(@PathVariable("id") Long id, Model model) {

		Podcast podcast = new Podcast();
		podcast.setId(id);
		podcast.setNome("Teste");
		podcast.setDescricao("Teste de descrição");
		podcast.setSite("http://www.podcast.com");
		model.addAttribute("podcast", podcast);

		return "podcast/formulario";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public String atualizarPodcast(@PathVariable("id") Long id,
			@Valid @ModelAttribute("podcast") Podcast podcast,
			BindingResult result, RedirectAttributes attr, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Verifique os erros no formulário.");
			model.addAttribute("tipoDaMensagem", "danger");

			model.addAttribute("podcast", podcast);
			return "podcast/formulario";
		} else {
			attr.addFlashAttribute("mensagem", "Podcast " + podcast.getNome()
					+ " editado com sucesso");
			attr.addFlashAttribute("tipoDaMensagem", "success");

			return "redirect:/podcasts";
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String removerPodcast(@PathVariable("id") Long id,
			RedirectAttributes attr) {
		attr.addFlashAttribute("mensagem", "Podcast apagado com sucesso");
		attr.addFlashAttribute("tipoDaMensagem", "info");

		return "redirect:/podcasts";
	}
}