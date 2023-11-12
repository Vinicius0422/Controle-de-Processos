package br.vinicius.projects.controleDeProcessos.domain.services.interfaces;

import br.vinicius.projects.controleDeProcessos.domain.dtos.ResponseDefault;
import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamado.ReclamadoDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamante.ReclamanteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReclamadoServiceIntfc {

    List<ReclamadoDto> getAllReclamados();

    ReclamadoDto getById(Long id);

    ReclamadoDto getByCpfOuCnpj(String cpf_cnpj);

    List<ReclamadoDto> getByNome(String nome);

    ResponseDefault saveReclamado(ReclamadoDto reclamadoDto);

    ResponseDefault updateReclamado(Long id, ReclamadoDto reclamadoDto);
}
