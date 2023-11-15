package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.estadoCivil.EstadoCivilDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.resultado.ResultadoDto;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.EstadoCivilService;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.ResultadoService;
import br.vinicius.projects.controleDeProcessos.repositories.EstadoCivilRepository;
import br.vinicius.projects.controleDeProcessos.repositories.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoServiceImpl implements ResultadoService {

    @Autowired
    private ResultadoRepository resultadoRepository;

    @Override
    public List<ResultadoDto> getAllResultado(){
        return resultadoRepository.findAll().stream().map(ResultadoDto::new).toList();
    }
}
