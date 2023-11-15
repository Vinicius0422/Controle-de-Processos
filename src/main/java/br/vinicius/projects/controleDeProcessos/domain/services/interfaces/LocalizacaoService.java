package br.vinicius.projects.controleDeProcessos.domain.services.interfaces;

import br.vinicius.projects.controleDeProcessos.domain.dtos.estadoCivil.EstadoCivilDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.localizacao.LocalizacaoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocalizacaoService {

    List<LocalizacaoDto> getAllLocalizacao();
}
