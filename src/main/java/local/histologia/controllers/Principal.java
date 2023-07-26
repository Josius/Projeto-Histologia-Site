package local.histologia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Principal {

	@RequestMapping
	public ModelAndView teste(){

		ModelAndView mv = new ModelAndView("teste.html");
		return mv;
	}
	@RequestMapping("sobre")
	public ModelAndView sobre(){

		ModelAndView mv = new ModelAndView("sobre.html");
		return mv;
	}
}
