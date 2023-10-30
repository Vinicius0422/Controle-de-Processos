package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.tipoConta.TipoContaDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.TipoConta;
import br.vinicius.projects.controleDeProcessos.repositories.TipoContaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TipoContaServiceImplTest {

    @Test
    private void startTipoConta(){
        tipoConta = new TipoConta(1L, "poupança");
        tipoContaDto = new TipoContaDto(1L, "poupança");
    }

    @Mock
    private TipoContaRepository tipoContaRepository;

    @Autowired
    @InjectMocks
    private TipoContaServiceImpl service;

    private TipoConta tipoConta;
    private TipoContaDto tipoContaDto;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startTipoConta();
    }

    @Test
    void whenFindAllThenReturnAnListOfTipoContasDTO() {
        when(tipoContaRepository.findAll()).thenReturn(List.of(tipoConta));
        List<TipoContaDto> response = service.getAllTipoConta();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(TipoContaDto.class, response.get(0).getClass());
        assertEquals(1L, response.get(0).getId());
        assertEquals("poupança", response.get(0).getNome());
    }
}

