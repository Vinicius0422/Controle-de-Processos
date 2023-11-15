package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.estadoCivil.EstadoCivilDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.faseProcessual.FaseProcessualDto;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.EstadoCivilService;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.FaseProcessualService;
import br.vinicius.projects.controleDeProcessos.repositories.EstadoCivilRepository;
import br.vinicius.projects.controleDeProcessos.repositories.FaseProcessualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaseProcessualServiceImpl implements FaseProcessualService {

    @Autowired
    private FaseProcessualRepository faseProcessualRepository;

    @Override
    public List<FaseProcessualDto> getAllFaseProcessual(){
        return faseProcessualRepository.findAll().stream().map(FaseProcessualDto::new).toList();
    }
}
