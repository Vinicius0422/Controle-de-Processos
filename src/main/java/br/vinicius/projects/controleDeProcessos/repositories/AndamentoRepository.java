package br.vinicius.projects.controleDeProcessos.repositories;

import br.vinicius.projects.controleDeProcessos.domain.entities.Andamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AndamentoRepository extends JpaRepository<Andamento, Long> {
}
