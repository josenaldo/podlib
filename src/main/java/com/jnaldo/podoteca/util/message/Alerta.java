package com.jnaldo.podoteca.util.message;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class Alerta {

	private void mensagem(RedirectAttributes attr, String mensagem,
			NivelDoAlerta nivelDoAlerta) {
		attr.addFlashAttribute(Messages.CHAVE_MENSAGEM, mensagem);
		attr.addFlashAttribute(Messages.CHAVE_NIVEL_DA_MENSAGEM,
				nivelDoAlerta.getName());
	}

	private void mensagem(ModelAndView modelAndView, String mensagem,
			NivelDoAlerta nivelDoAlerta) {
		modelAndView.addObject(Messages.CHAVE_MENSAGEM, mensagem);
		modelAndView.addObject(Messages.CHAVE_NIVEL_DA_MENSAGEM,
				nivelDoAlerta.getName());

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
