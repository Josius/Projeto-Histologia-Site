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
		// LaminaRecord lamina = laminaService.getLamina("bfe6ff6c-b27b-4154-99e6-d205175c4c3a");
		// LaminaRecord lamina = laminaService.getLamina("316f2232-07bf-4021-83e7-7b3ecd180f01");
		// LaminaRecord lamina = laminaService.getLamina("69a2f480-ddbb-494e-b6f6-747850d8621e");
		// LaminaRecord lamina = laminaService.getLamina("50e8ff51-b66f-4097-bff5-a9c4319ce90c");
		
		mv.addObject("lamina", lamina);

		return mv;
	}
}

// "f391e054-6dde-4198-bdbd-14fa9496e2c4"	-> id Pele Fina
// "ac9344eb-2f29-4402-bba9-82a353b8899e"	-> id Pele Grossa
// "bfe6ff6c-b27b-4154-99e6-d205175c4c3a"	-> id L01TraqueiaEEpiglote
// "316f2232-07bf-4021-83e7-7b3ecd180f01"	-> id L03TraqueiaEEpiglote
// "69a2f480-ddbb-494e-b6f6-747850d8621e"	-> id LR02TraqueiaEEpigloteDeCao
// "50e8ff51-b66f-4097-bff5-a9c4319ce90c"	-> id LR05Pulmao