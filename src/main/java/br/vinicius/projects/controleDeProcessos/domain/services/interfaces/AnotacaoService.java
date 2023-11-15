package br.vinicius.projects.controleDeProcessos.domain.services.interfaces;

import br.vinicius.projects.controleDeProcessos.domain.dtos.ResponseDefault;
import br.vinicius.projects.controleDeProcessos.domain.dtos.anotacao.AnotacaoDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.estadoCivil.EstadoCivilDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.Anotacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnotacaoService {

    List<AnotacaoDto> getAllAnotacao();

    ResponseDefault saveAnotacao(AnotacaoDto anotacaoDto);

    ResponseDefault updateAnotacao(Long id, AnotacaoDto anotacaoDto);
}
