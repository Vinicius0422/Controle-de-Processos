package br.vinicius.projects.controleDeProcessos.domain.services.interfaces;

import br.vinicius.projects.controleDeProcessos.domain.dtos.ResponseDefault;
import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamante.ReclamanteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReclamanteService {

    List<ReclamanteDto> getAllReclamantes();

    ReclamanteDto getById(Long id);

    ReclamanteDto getByCpf(String cpf);

    List<ReclamanteDto> getByNome(String nome);

    ResponseDefault saveReclamante(ReclamanteDto reclamanteDto);

    ResponseDefault updateReclamante(Long id, ReclamanteDto reclamanteDto);
}
