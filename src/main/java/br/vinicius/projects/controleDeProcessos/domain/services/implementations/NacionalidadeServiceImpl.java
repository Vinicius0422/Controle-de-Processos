package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.nacionalidade.NacionalidadeDto;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.NacionalidadeService;
import br.vinicius.projects.controleDeProcessos.repositories.NacionalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NacionalidadeServiceImpl implements NacionalidadeService {

    @Autowired
    NacionalidadeRepository nacionalidadeRepository;

    @Override
    public List<NacionalidadeDto> getAllNacionalidades(){
        return nacionalidadeRepository.findAll().stream().map(NacionalidadeDto::new).toList();
    }
}
