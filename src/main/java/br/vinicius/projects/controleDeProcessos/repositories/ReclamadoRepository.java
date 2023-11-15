package br.vinicius.projects.controleDeProcessos.repositories;

import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReclamadoRepository extends JpaRepository<Reclamado, Long> {

    Optional<Reclamado> findByCpfCnpj(String cpf_cnpj);
    List<Reclamado> findByNomeContains(String nome);
    boolean existsByCpfCnpj(String cpfCnpj);
    Long findByCpfCnpjEquals(String cpf_cnpj);
}
