package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.estadoCivil.EstadoCivilDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.localizacao.LocalizacaoDto;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.EstadoCivilService;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.LocalizacaoService;
import br.vinicius.projects.controleDeProcessos.repositories.EstadoCivilRepository;
import br.vinicius.projects.controleDeProcessos.repositories.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizacaoServiceImpl implements LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Override
    public List<LocalizacaoDto> getAllLocalizacao(){
        return localizacaoRepository.findAll().stream().map(LocalizacaoDto::new).toList();
    }
}
