package br.vinicius.projects.controleDeProcessos.repositories;

import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamanteRepository extends JpaRepository<Reclamante, Long> {
}
