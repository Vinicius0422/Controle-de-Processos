package br.vinicius.projects.controleDeProcessos.repositories;

import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReclamadoRepository extends JpaRepository<Reclamado, Long> {

    Optional<Reclamado> findByCpf_Cnpj(String cpf_cnpj);
    List<Reclamado> findByNomeContains(String nome);
    boolean existsByCpf_Cnpj(String cpf_cnpj);
    Long findByCpf_CnpjEquals(String cpf_cnpj);
}
