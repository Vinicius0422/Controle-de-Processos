package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.tipoConta.TipoContaDto;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.TipoContaServiceIntfc;
import br.vinicius.projects.controleDeProcessos.repositories.TipoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoContaServiceImpl implements TipoContaServiceIntfc {

    @Autowired
    private TipoContaRepository tipoContaRepository;

    @Override
    public List<TipoContaDto> getAllTipoConta() {
       return tipoContaRepository.findAll().stream().map(TipoContaDto::new).toList();
    }
}
