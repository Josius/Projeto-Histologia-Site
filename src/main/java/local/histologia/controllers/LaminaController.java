package local.histologia.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LaminaController {
	
	@RequestMapping("lamina")
	public ModelAndView lamina() throws IOException {

		ModelAndView mv = new ModelAndView("visualizando/lamina.html");

		String l = "";
		try (BufferedReader inHtml = new BufferedReader(
				// new FileReader("src/main/resources/templates/Assets/Narratives/L60PelefinaHE40XB.htm"))) {
					
				new FileReader("src/main/resources/templates/Assets/Narratives/L01PeleGrossaCoximdeGatoL2HE40.htm"))) {
			StringBuilder sb = new StringBuilder();

			while ((l = inHtml.readLine()) != null) {
				sb.append(l);
			}
			l = sb.toString();
			mv.addObject("inHtml", l);
		} catch (Exception e) {
			System.out.println("ERRRROUUROUROURO");
			e.printStackTrace();
		}

		return mv;
	}
}
