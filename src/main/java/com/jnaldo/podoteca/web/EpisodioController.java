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

import com.jnaldo.podoteca.model.Episodio;

@Controller
@RequestMapping("episodios")
public class EpisodioController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView listarepisodios(Model model) {
		ModelAndView mav = new ModelAndView();
		List<Episodio> episodios = new ArrayList<Episodio>();

		Episodio episodio1 = new Episodio();
		episodio1.setId(1l);
		episodio1
				.setTitulo("99Vidas 95 – 2-Pak: Maui Mallard e Esquadrão Marte");
		episodio1
				.setDescricao("Para os que reclamam de atraso, um 2-Pak adiantado. Evandro de Freitas encerra o último ciclo da série mais pessoal do 99vidas com dois jogos que curtiram o sucesso com a ajuda da fixação […]");
		episodio1
				.setUrl("http://99vidas.com.br/99vidas-95-2-pak-maui-mallard-e-esquadrao-marte/");

		Episodio episodio2 = new Episodio();
		episodio2.setId(2l);
		episodio2.setTitulo("99Vidas 94 – Brinquedos da Infância");
		episodio2
				.setDescricao("O episódio dessa semana volta aos anos da tenra infância para falar dos brinquedos que nos entretinham na ausência dos videogames, no melhor Estilo 99vidas! Jurandir Filho (@jurandirfilho), Izzy Nobre (@izzynobre), Evandro de Freitas […]");
		episodio2
				.setUrl("http://99vidas.com.br/99vidas-94-brinquedos-da-infancia/");

		Episodio episodio3 = new Episodio();
		episodio3.setId(3l);
		episodio3.setTitulo("99Vidas 93 – God of War, A Série");
		episodio3
				.setDescricao("God of War foi uma aposta da Sony no PS2, que muitos julgavam inferior e incapaz, e que acabou gerando uma das franquias mais reconhecidas da atualidade. O 99vidas analisou os jogos dessa série, que […]");
		episodio3
				.setUrl("http://99vidas.com.br/99vidas-93-god-of-war-a-serie/");

		episodios.add(episodio1);
		episodios.add(episodio2);
		episodios.add(episodio3);

		mav.setViewName("episodio/listar");
		mav.addObject("episodios", episodios);

		return mav;

	}

	@RequestMapping("adicionar")
	public String adicionarEpisodio(Model model) {

		model.addAttribute("episodio", new Episodio());

		return "episodio/formulario";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String salvarEpisodio(
			@Valid @ModelAttribute("episodio") Episodio episodio,
			BindingResult result, RedirectAttributes attr, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Verifique os erros no formulário.");
			model.addAttribute("tipoDaMensagem", "danger");
			model.addAttribute("episodio", episodio);
			return "episodio/formulario";
		} else {
			attr.addFlashAttribute("mensagem",
					"Episódio " + episodio.getTitulo()
							+ " adicionado com sucesso");
			attr.addFlashAttribute("tipoDaMensagem", "success");
			return "redirect:/episodios";
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String mostraEpisodio() {
		return "episodio/visualizar";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String visualizarEpisodio(@PathVariable("id") Long id, Model model) {

		Episodio episodio = new Episodio();
		episodio.setId(id);
		episodio.setTitulo("Teste");
		episodio.setDescricao("Teste de descrição");
		episodio.setUrl("http://www.episodio.com");
		model.addAttribute("episodio", episodio);

		return "episodio/visualizar";
	}

	@RequestMapping("{id}/editar")
	public String editarEpisodio(@PathVariable("id") Long id, Model model) {

		Episodio episodio = new Episodio();
		episodio.setId(id);
		episodio.setTitulo("Teste");
		episodio.setDescricao("Teste de descrição");
		episodio.setUrl("http://www.episodio.com");
		model.addAttribute("episodio", episodio);

		return "episodio/formulario";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public String atualizarEpisodio(@PathVariable("id") Long id,
			@Valid @ModelAttribute("episodio") Episodio episodio,
			BindingResult result, RedirectAttributes attr, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Verifique os erros no formulário.");
			model.addAttribute("tipoDaMensagem", "danger");

			model.addAttribute("episodio", episodio);
			return "episodio/formulario";
		} else {
			attr.addFlashAttribute("mensagem",
					"Episodio " + episodio.getTitulo() + " editado com sucesso");
			attr.addFlashAttribute("tipoDaMensagem", "success");

			return "redirect:/episodios";
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String removerEpisodio(@PathVariable("id") Long id,
			RedirectAttributes attr) {
		attr.addFlashAttribute("mensagem", "Episodio apagado com sucesso");
		attr.addFlashAttribute("tipoDaMensagem", "info");

		return "redirect:/episodios";
	}

}