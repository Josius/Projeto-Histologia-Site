package local.histologia.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import local.histologia.entities.Lamina;

public interface LaminaRepository extends JpaRepository<Lamina, UUID>{
	
}
