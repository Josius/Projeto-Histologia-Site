package local.histologia.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import local.histologia.entities.Lamina;
import local.histologia.repositories.LaminaRepository;

@Service
public class LaminaService {

	@Autowired
	LaminaRepository laminaRepository;

	public Lamina getLamina(String id) {
		
		Optional<Lamina> lamina = laminaRepository.findById(UUID.fromString(id));
		
		if(lamina.isEmpty()) {
			Lamina respLamina = new Lamina();
			respLamina.setNome("Não encontrado");
		}
		
		getArquivoHtmESetEmDescricaoHtm(lamina);

		return lamina.get();
	}

	private void getArquivoHtmESetEmDescricaoHtm(Optional<Lamina> lamina) {
		lamina.get().setDescricaoHtm(getDescricaoHtm(lamina.get().getDescricaoHtm()));
	}

	private String getDescricaoHtm(String rotaHtm) {
		String descricao = "";
		try (BufferedReader inHtml = new BufferedReader(
				new FileReader(rotaHtm))) {
			
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
