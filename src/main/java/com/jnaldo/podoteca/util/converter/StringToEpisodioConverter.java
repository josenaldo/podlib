package com.jnaldo.podoteca.util.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jnaldo.podoteca.business.exceptions.BusinessException;
import com.jnaldo.podoteca.business.services.EpisodioService;
import com.jnaldo.podoteca.model.Episodio;

@Component("stringToEpisodioConverter")
public class StringToEpisodioConverter implements Converter<String, Episodio> {

	@Autowired
	private EpisodioService episodioService;

	public Episodio convert(String source) {

		Episodio episodio = null;

		try {
			Long idEpisodio = Long.valueOf(source);

			episodio = this.episodioService.find(idEpisodio);

			if (episodio == null) {
				throw new IllegalArgumentException("Episodio não encontrado");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
					"Valor não é um id de episodio válido", e);
		} catch (BusinessException e) {
			throw new IllegalStateException(e);
		}

		return episodio;
	}
}
