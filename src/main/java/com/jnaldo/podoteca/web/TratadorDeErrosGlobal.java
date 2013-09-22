package com.jnaldo.podoteca.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.jnaldo.podoteca.util.message.Alerta;
import com.jnaldo.podoteca.web.exception.WebException;

@ControllerAdvice
public class TratadorDeErrosGlobal {

	@Autowired
	private Alerta alerta;

	@ExceptionHandler(WebException.class)
	public ModelAndView handleWebException(WebException ex) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");

		this.alerta.erro(modelAndView, ex.getMessage());

		return modelAndView;
	}
}
