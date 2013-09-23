package com.jnaldo.podoteca.util.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jnaldo.podoteca.model.Participante;
import com.jnaldo.podoteca.services.ParticipanteService;

@Component("stringToParticipanteConverter")
public class StringToParticipanteConverter implements
		Converter<String, Participante> {

	@Autowired
	private ParticipanteService participanteService;

	public Participante convert(String source) {

		Participante participante = null;

		try {
			Long idParticipante = Long.valueOf(source);

			participante = this.participanteService.find(idParticipante);

			if (participante == null) {
				throw new IllegalArgumentException(
						"Participante não encontrado");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
					"Valor não é um id de participante válido", e);
		}

		return participante;
	}
}
