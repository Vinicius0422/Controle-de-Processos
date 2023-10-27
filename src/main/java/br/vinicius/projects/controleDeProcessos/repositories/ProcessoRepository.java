package br.vinicius.projects.controleDeProcessos.repositories;

import br.vinicius.projects.controleDeProcessos.domain.entities.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}
