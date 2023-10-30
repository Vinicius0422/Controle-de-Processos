package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.estadoCivil.EstadoCivilDto;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.EstadoCivilServiceIntfc;
import br.vinicius.projects.controleDeProcessos.repositories.EstadoCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilServiceIntfc {

    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

    @Override
    public List<EstadoCivilDto> getAllEstadoCivil(){
        return estadoCivilRepository.findAll().stream().map(EstadoCivilDto::new).toList();
    }
}
