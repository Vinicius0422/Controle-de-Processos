package br.vinicius.projects.controleDeProcessos.repositories;

import br.vinicius.projects.controleDeProcessos.domain.entities.Anotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {
}
