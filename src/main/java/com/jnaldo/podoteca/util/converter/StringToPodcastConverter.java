package com.jnaldo.podoteca.util.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jnaldo.podoteca.model.Podcast;
import com.jnaldo.podoteca.services.PodcastService;

@Component("stringToPodcastConverter")
public class StringToPodcastConverter implements Converter<String, Podcast> {

	@Autowired
	private PodcastService podcastService;

	public StringToPodcastConverter() {
		System.out.println("Iniciando conversor");
	}

	public Podcast convert(String source) {
		System.out.println("Convertendo");
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
		}

		return podcast;
	}
}
