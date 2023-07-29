package local.histologia.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		// Lamina lamina = laminaService.criaLamina();
		
		mv.addObject("lamina", lamina);

		return mv;
	}

	// @RequestMapping("lamina")
	// public ModelAndView lamina() throws IOException {

	// ModelAndView mv = new ModelAndView("visualizando/lamina.html");

	// List<String> objeto = new ArrayList<>();
	// objeto.add("Pele Fina");
	// // objeto.add("Pele Grossa");

	// String l = "";
	// try (BufferedReader inHtml = new BufferedReader(
	// new
	// FileReader("src/main/resources/templates/Assets/Narratives/L60PelefinaHE40XB.htm")))
	// {
	// // new
	// FileReader("src/main/resources/templates/Assets/Narratives/L01PeleGrossaCoximdeGatoL2HE40.htm")))
	// {
	// StringBuilder sb = new StringBuilder();

	// while ((l = inHtml.readLine()) != null) {
	// sb.append(l);
	// }

	// l = sb.toString();
	// objeto.add(l);
	// } catch (Exception e) {
	// System.out.println("ERRRROUUROUROURO");
	// e.printStackTrace();
	// }
	// objeto.add("Images/L60PelefinaHE40XB.pff");
	// // objeto.add("Images/L01PeleGrossaCoximdeGatoL2HE40X.pff");

	// objeto.add("zAnnotationPath=Assets/Annotations/Narratives/L60PelefinaHE40XB-annotations.xml");
	// //
	// objeto.add("zAnnotationPath=Assets/Annotations/Narratives/L01PeleGrossaCoximdeGatoL2HE40X-annotations.xml");

	// mv.addObject("configs", objeto);

	// return mv;
	// }
}
