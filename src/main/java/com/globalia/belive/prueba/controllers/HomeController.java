package com.globalia.belive.prueba.controllers;

import com.globalia.belive.prueba.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	private CacheManager cacheManager;

	@GetMapping (value = { "/" })
	public ModelAndView loadFormPage(HttpServletRequest request) {
		User user = new User();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("html/form-page");
		modelAndView.addObject(user);

		return modelAndView;
	}

	@PostMapping("/register")
	public String submitForm(@Valid @ModelAttribute("user") User user,
							 BindingResult bindingResult, Model model) {
		System.out.println(user);

		if (bindingResult.hasErrors()) {
			return "html/form-page";
		} else {
			return "html/succes-register";
		}
	}

}
