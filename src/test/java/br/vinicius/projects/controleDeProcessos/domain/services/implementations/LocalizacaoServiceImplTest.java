package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.localizacao.LocalizacaoDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.resultado.ResultadoDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.Localizacao;
import br.vinicius.projects.controleDeProcessos.domain.entities.Processo;
import br.vinicius.projects.controleDeProcessos.domain.entities.Resultado;
import br.vinicius.projects.controleDeProcessos.repositories.LocalizacaoRepository;
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

class LocalizacaoServiceImplTest {

    @Test
    private void startLocalizcao(){
        localizacao = new Localizacao(1L, "Arquivo", processos);
        localizacaoDto = new LocalizacaoDto(1L, "Arquivo", processos);
    }

    @Mock
    private LocalizacaoRepository localizacaoRepository;

    List<Processo> processos;
    private Localizacao localizacao;
    private LocalizacaoDto localizacaoDto;

    @Autowired
    @InjectMocks
    private LocalizacaoServiceImpl localizacaoService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startLocalizcao();
    }

    @Test
    void whenFindAllThenReturnAnListOfLocalizacaoDTO() {
        when(localizacaoRepository.findAll()).thenReturn(List.of(localizacao));
        List<LocalizacaoDto> response = localizacaoService.getAllLocalizacao();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(localizacaoDto, response.get(0));
        assertEquals(LocalizacaoDto.class, response.get(0).getClass());
        assertEquals(1L, response.get(0).getId());
        assertEquals("Arquivo", response.get(0).getNome());
    }

    @Test
    void whenFindAllThenReturnAnListEmpty() {
        when(localizacaoRepository.findAll()).thenReturn(new ArrayList<>());
        List<LocalizacaoDto> response = localizacaoService.getAllLocalizacao();

        assertTrue(response.isEmpty());
    }
}