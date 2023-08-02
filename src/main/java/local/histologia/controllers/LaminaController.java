package local.histologia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import local.histologia.entities.Lamina;
import local.histologia.services.LaminaService;

@Controller
public class LaminaController {

	@Autowired
	LaminaService laminaService;

	@RequestMapping("lamina")
	public ModelAndView getLamina() {

		ModelAndView mv = new ModelAndView("visualizando/lamina.html");

		Lamina lamina = laminaService.getLamina(2L);
		
		mv.addObject("lamina", lamina);

		return mv;
	}
}
