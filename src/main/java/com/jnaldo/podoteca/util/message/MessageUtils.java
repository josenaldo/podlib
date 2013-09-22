package com.jnaldo.podoteca.util.message;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class MessageUtils {

	private static final String CHAVE_NIVEL_DA_MENSAGEM = "tipoDaMensagem";
	private static final String CHAVE_MENSAGEM = "mensagem";

	public void mensagem(RedirectAttributes attr, String mensagem,
			NivelDoAlerta nivelDoAlerta) {
		attr.addFlashAttribute(CHAVE_MENSAGEM, mensagem);
		attr.addFlashAttribute(CHAVE_NIVEL_DA_MENSAGEM, nivelDoAlerta.getName());
	}

	public void mensagem(ModelAndView modelAndView, String mensagem,
			NivelDoAlerta nivelDoAlerta) {
		modelAndView.addObject(CHAVE_MENSAGEM, mensagem);
		modelAndView
				.addObject(CHAVE_NIVEL_DA_MENSAGEM, nivelDoAlerta.getName());

	}

}
