package com.jnaldo.podoteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PodcastController {

	@RequestMapping("/")
	public String listPodcasts(Model model) {

		model.addAttribute("message", "Lambda, lambda, lambda, Nerds!");

		return "index";
	}
}