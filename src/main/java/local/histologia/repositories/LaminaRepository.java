package local.histologia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import local.histologia.entities.Lamina;

public interface LaminaRepository extends JpaRepository<Lamina, Long>{
	
}
