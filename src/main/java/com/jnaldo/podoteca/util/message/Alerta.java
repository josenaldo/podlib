package com.jnaldo.podoteca.util.message;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class Alerta {

	private static final String CHAVE_NIVEL_DA_MENSAGEM = "tipoDaMensagem";
	private static final String CHAVE_MENSAGEM = "mensagem";

	public static final String ERROS_NO_FORMULARIO = "Verifique os erros no formulário.";

	public static final String PODCAST_LISTA_VAZIA = "Nenhum podcast foi encontrado.";
	public static final String PODCAST_NAO_ENCONTRADO = "Podcast procurado não encontrado.";
	public static final String PODCAST_SALVO = "Podcast salvo com sucesso.";
	public static final String PODCAST_APAGADO = "Podcast apagado com sucesso.";

	public static final String EPISODIO_LISTA_VAZIA = "Nenhum episódio foi encontrado.";;
	public static final String EPISODIO_NAO_ENCONTRADO = "Episódio procurado não encontrado.";
	public static final String EPISODIO_SALVO = "Episódio salvo com sucesso.";
	public static final String EPISODIO_APAGADO = "Episódio apagado com sucesso.";

	public static final String PARTICIPANTE_LISTA_VAZIA = "Nenhum participante foi encontrado.";
	public static final String PARTICIPANTE_NAO_ENCONTRADO = "Participante procurado não encontrado.";
	public static final String PARTICIPANTE_SALVO = "Participante salvo com sucesso.";
	public static final String PARTICIPANTE_APAGADO = "Participante apagado com sucesso.";

	private void mensagem(RedirectAttributes attr, String mensagem,
			NivelDoAlerta nivelDoAlerta) {
		attr.addFlashAttribute(CHAVE_MENSAGEM, mensagem);
		attr.addFlashAttribute(CHAVE_NIVEL_DA_MENSAGEM, nivelDoAlerta.getName());
	}

	private void mensagem(ModelAndView modelAndView, String mensagem,
			NivelDoAlerta nivelDoAlerta) {
		modelAndView.addObject(CHAVE_MENSAGEM, mensagem);
		modelAndView
				.addObject(CHAVE_NIVEL_DA_MENSAGEM, nivelDoAlerta.getName());

	}

	public void informacao(ModelAndView modelAndView, String mensagem) {
		this.mensagem(modelAndView, mensagem, NivelDoAlerta.INFO);
	}

	public void informacao(RedirectAttributes redirectAttributes,
			String mensagem) {
		this.mensagem(redirectAttributes, mensagem, NivelDoAlerta.INFO);
	}

	public void sucesso(ModelAndView modelAndView, String mensagem) {
		this.mensagem(modelAndView, mensagem, NivelDoAlerta.SUCCESS);
	}

	public void sucesso(RedirectAttributes redirectAttributes, String mensagem) {
		this.mensagem(redirectAttributes, mensagem, NivelDoAlerta.SUCCESS);
	}

	public void alerta(ModelAndView modelAndView, String mensagem) {
		this.mensagem(modelAndView, mensagem, NivelDoAlerta.WARNING);
	}

	public void alerta(RedirectAttributes redirectAttributes, String mensagem) {
		this.mensagem(redirectAttributes, mensagem, NivelDoAlerta.WARNING);
	}

	public void erro(ModelAndView modelAndView, String mensagem) {
		this.mensagem(modelAndView, mensagem, NivelDoAlerta.DANGER);
	}

	public void erro(RedirectAttributes redirectAttributes, String mensagem) {
		this.mensagem(redirectAttributes, mensagem, NivelDoAlerta.DANGER);
	}

}
