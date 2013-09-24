package com.jnaldo.podoteca.util.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jnaldo.podoteca.business.exceptions.BusinessException;
import com.jnaldo.podoteca.business.services.PodcastService;
import com.jnaldo.podoteca.model.Podcast;

@Component("stringToPodcastConverter")
public class StringToPodcastConverter implements Converter<String, Podcast> {

	@Autowired
	private PodcastService podcastService;

	public Podcast convert(String source) {

		Podcast podcast = null;

		try {
			Long idPodcast = Long.valueOf(source);

			podcast = this.podcastService.find(idPodcast);

			if (podcast == null) {
				throw new IllegalArgumentException("Podcast não encontrado");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
					"Valor não é um id de podcast válido", e);
		} catch (BusinessException e) {
			throw new IllegalStateException(e);
		}

		return podcast;
	}
}
