package com.jnaldo.podoteca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnaldo.podoteca.domain.Podcast;

@Controller
@RequestMapping("podcast")
public class PodcastController {

	@RequestMapping("")
	public String listarPodcasts(Model model) {

		List<Podcast> podcasts = new ArrayList<Podcast>();

		Podcast podcast1 = new Podcast();
		podcast1.setNome("Nerdcast");
		podcast1.setDescricao("Nerdcast é o primeiro podcast totalmente nerd do Brasil. É um papo bastante informal entre os criadores do site e convidados sobre os mais derivados assuntos do mundo nerd.");
		podcast1.setSite("http://jovemnerd.ig.com.br/nerdcast/");

		Podcast podcast2 = new Podcast();
		podcast2.setNome("Matando Robôs Gigantes");
		podcast2.setDescricao("O Matando Robôs Gigantes é um Podcast de humor dividido em quatro episódios: Cinema, Games, Quadrinhos e a Voz do Robô.");
		podcast2.setSite("http://jovemnerd.ig.com.br/matando-robos-gigantes/");

		Podcast podcast3 = new Podcast();
		podcast3.setNome("99 Vidas");
		podcast3.setDescricao("O 99Vidas é um site que publica semanalmente podcasts sobre temas que marcaram a infância e adolescência de todos os amantes de videogames.");
		podcast3.setSite("http://99vidas.com.br/");

		podcasts.add(podcast1);
		podcasts.add(podcast2);
		podcasts.add(podcast3);

		model.addAttribute("podcasts", podcasts);

		return "podcast/listar";
	}

	@RequestMapping("adicionar")
	public String adicionarPodcast() {

		return "podcast/adicionar";
	}

	@RequestMapping("editar")
	public String editarPodcast() {
		return "podcast/editar";
	}

	@RequestMapping("salvar")
	public String salvarPodcast() {
		return "redirect:";
	}

	@RequestMapping("remover")
	public String removerPodcast() {
		return "redirect:";
	}
}