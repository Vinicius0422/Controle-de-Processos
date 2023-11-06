package br.vinicius.projects.controleDeProcessos.repositories;

import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReclamanteRepository extends JpaRepository<Reclamante, Long> {

    Optional<Reclamante> findByCpf(String cpf);
    List<Reclamante> findByNomeContains(String nome);
    boolean existsByCpf(String cpf);
    boolean existsByRgAndOrgaoRg(String rg, String orgaoRg);
    boolean existsByBancoAndAgenciaAndConta(String banco, String agencia, String conta);
    Long findByCpfEquals(String cpf);
    Long findByRgAndOrgaoRgEquals(String rg, String orgaoRg);
    Long findByBancoAndAgenciaAndContaEquals(String banco, String agencia, String conta);
}
