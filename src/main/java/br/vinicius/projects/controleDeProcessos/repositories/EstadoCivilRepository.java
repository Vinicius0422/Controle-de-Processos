package br.vinicius.projects.controleDeProcessos.repositories;

import br.vinicius.projects.controleDeProcessos.domain.entities.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long> {
}
