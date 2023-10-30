package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.estadoCivil.EstadoCivilDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.EstadoCivil;
import br.vinicius.projects.controleDeProcessos.repositories.EstadoCivilRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EstadoCivilServiceImplTest {

    @Test
    private void startEstadoCivil(){
        estadoCivil = new EstadoCivil(1L, "Solteiro");
        estadoCivilDto = new EstadoCivilDto(1L, "Solteiro");
    }

    @Mock
    private EstadoCivilRepository estadoCivilRepository;

    private EstadoCivil estadoCivil;
    private EstadoCivilDto estadoCivilDto;

    @Autowired
    @InjectMocks
    private EstadoCivilServiceImpl estadoCivilService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startEstadoCivil();
    }

    @Test
    void whenFindAllThenReturnAnListOfEstadoCivilDTO() {
        when(estadoCivilRepository.findAll()).thenReturn(List.of(estadoCivil));
        List<EstadoCivilDto> response = estadoCivilService.getAllEstadoCivil();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(EstadoCivilDto.class, response.get(0).getClass());
        assertEquals(1L, response.get(0).getId());
        assertEquals("Solteiro", response.get(0).getNome());
    }
}
