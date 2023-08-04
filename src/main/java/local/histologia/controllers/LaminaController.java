package local.histologia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import local.histologia.records.LaminaRecord;
import local.histologia.services.LaminaService;

@Controller
@RequestMapping("/lamina")
public class LaminaController {

	private final LaminaService laminaService;

	public LaminaController(LaminaService laminaService) {
		
		this.laminaService = laminaService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getLamina() {

		ModelAndView mv = new ModelAndView("visualizando/lamina.html");

		LaminaRecord lamina = laminaService.getLamina("f391e054-6dde-4198-bdbd-14fa9496e2c4");
		// LaminaRecord lamina = laminaService.getLamina("ac9344eb-2f29-4402-bba9-82a353b8899e");
		
		mv.addObject("lamina", lamina);

		return mv;
	}
}

// "f391e054-6dde-4198-bdbd-14fa9496e2c4"	-> id Pele Fina
// "ac9344eb-2f29-4402-bba9-82a353b8899e"	-> id Pele Grossa