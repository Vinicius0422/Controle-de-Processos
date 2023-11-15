package br.vinicius.projects.controleDeProcessos.domain.services.interfaces;

import br.vinicius.projects.controleDeProcessos.domain.dtos.tipoConta.TipoContaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoContaService {

    List<TipoContaDto> getAllTipoConta();
}
