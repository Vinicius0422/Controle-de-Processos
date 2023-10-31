package br.vinicius.projects.controleDeProcessos.domain.services.interfaces;

import br.vinicius.projects.controleDeProcessos.domain.dtos.nacionalidade.NacionalidadeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NacionalidadeServiceIntfc {

    List<NacionalidadeDto> getAllNacionalidades();
}
