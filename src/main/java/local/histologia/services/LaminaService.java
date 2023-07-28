package local.histologia.services;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.stereotype.Service;

import local.histologia.entities.Lamina;

@Service
public class LaminaService {

	public Lamina criaLamina() {
		Lamina laminaPFina = new Lamina();
		laminaPFina.setNome("Pele Fina");
		laminaPFina.setDescricaoHtm(getDescricaoHtm("src/main/resources/templates/Assets/Narratives/L60PelefinaHE40XB.htm"));
		laminaPFina.setRotaPff("Images/L60PelefinaHE40XB.pff");
		laminaPFina.setRotaXml("zAnnotationPath=Assets/Annotations/Narratives/L60PelefinaHE40XB-annotations.xml");
		
		Lamina laminaPGrossa = new Lamina();
		laminaPGrossa.setNome("Pele Grossa");
		laminaPGrossa.setDescricaoHtm(getDescricaoHtm("src/main/resources/templates/Assets/Narratives/L01PeleGrossaCoximdeGatoL2HE40.htm"));
		laminaPGrossa.setRotaPff("Images/L01PeleGrossaCoximdeGatoL2HE40X.pff");
		laminaPGrossa.setRotaXml("zAnnotationPath=Assets/Annotations/Narratives/L01PeleGrossaCoximdeGatoL2HE40X-annotations.xml");

		return laminaPFina;
		// return laminaPGrossa;
	}

	private String getDescricaoHtm(String rotaHtm) {
		String descricao = "";
		try (BufferedReader inHtml = new BufferedReader(
				new FileReader(rotaHtm))) {
				// new FileReader("src/main/resources/templates/Assets/Narratives/L60PelefinaHE40XB.htm"))) {
			// new FileReader("src/main/resources/templates/Assets/Narratives/L01PeleGrossaCoximdeGatoL2HE40.htm"))) {
			StringBuilder sb = new StringBuilder();

			while ((descricao = inHtml.readLine()) != null) {
				sb.append(descricao);
			}

			descricao = sb.toString();
			
		} catch (Exception e) {
			System.out.println("ERRRROUUROUROURO");
			e.printStackTrace();
		}

		return descricao;
	}
}
