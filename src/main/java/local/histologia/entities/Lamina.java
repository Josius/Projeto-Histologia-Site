package local.histologia.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Lamina {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY) // 
	private UUID id;
	private String nome;
	private String descricaoHtm;
	private String rotaPff;
	private String rotaXml;

}