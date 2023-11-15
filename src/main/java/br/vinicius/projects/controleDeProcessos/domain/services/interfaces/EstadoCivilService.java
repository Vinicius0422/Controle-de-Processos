package br.vinicius.projects.controleDeProcessos.domain.services.interfaces;

import br.vinicius.projects.controleDeProcessos.domain.dtos.estadoCivil.EstadoCivilDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstadoCivilService {

    List<EstadoCivilDto> getAllEstadoCivil();
}
