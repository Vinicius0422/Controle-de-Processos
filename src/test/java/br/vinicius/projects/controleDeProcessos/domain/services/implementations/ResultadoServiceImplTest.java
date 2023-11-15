package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.estadoCivil.EstadoCivilDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.localizacao.LocalizacaoDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.resultado.ResultadoDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.EstadoCivil;
import br.vinicius.projects.controleDeProcessos.domain.entities.Processo;
import br.vinicius.projects.controleDeProcessos.domain.entities.Resultado;
import br.vinicius.projects.controleDeProcessos.repositories.EstadoCivilRepository;
import br.vinicius.projects.controleDeProcessos.repositories.ResultadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ResultadoServiceImplTest {

    @Test
    private void startResultado(){
        resultado = new Resultado(1L, "Julgado Procedente", processos);
        resultadoDto = new ResultadoDto(1L, "Julgado Procedente", processos);
    }

    @Mock
    private ResultadoRepository resultadoRepository;

    List<Processo> processos;
    private Resultado resultado;
    private ResultadoDto resultadoDto;

    @Autowired
    @InjectMocks
    private ResultadoServiceImpl resultadoService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startResultado();
    }

    @Test
    void whenFindAllThenReturnAnListOfResultadoDTO() {
        when(resultadoRepository.findAll()).thenReturn(List.of(resultado));
        List<ResultadoDto> response = resultadoService.getAllResultado();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(resultadoDto, response.get(0));
        assertEquals(ResultadoDto.class, response.get(0).getClass());
        assertEquals(1L, response.get(0).getId());
        assertEquals("Julgado Procedente", response.get(0).getNome());
    }

    @Test
    void whenFindAllThenReturnAnListEmpty() {
        when(resultadoRepository.findAll()).thenReturn(new ArrayList<>());
        List<ResultadoDto> response = resultadoService.getAllResultado();

        assertTrue(response.isEmpty());
    }
}