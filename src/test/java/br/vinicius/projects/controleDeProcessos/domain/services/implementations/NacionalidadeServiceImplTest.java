package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.localizacao.LocalizacaoDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.nacionalidade.NacionalidadeDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamante.ReclamanteDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.Localizacao;
import br.vinicius.projects.controleDeProcessos.domain.entities.Nacionalidade;
import br.vinicius.projects.controleDeProcessos.domain.entities.Processo;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamante;
import br.vinicius.projects.controleDeProcessos.repositories.LocalizacaoRepository;
import br.vinicius.projects.controleDeProcessos.repositories.NacionalidadeRepository;
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

class NacionalidadeServiceImplTest {

    @Test
    private void startNacionalidade(){
        nacionalidade = new Nacionalidade(1L, "Brasileiro", reclamantes);
        nacionalidadeDTO = new NacionalidadeDto(1L, "Brasileiro", reclamantes);
    }

    @Mock
    private NacionalidadeRepository nacionalidadeRepository;

    List<Reclamante> reclamantes;

    private Nacionalidade nacionalidade;
    private NacionalidadeDto nacionalidadeDTO;

    @Autowired
    @InjectMocks
    private NacionalidadeServiceImpl nacionalidadeService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startNacionalidade();
    }

    @Test
    void whenFindAllThenReturnAnListOfLocalizacaoDTO() {
        when(nacionalidadeRepository.findAll()).thenReturn(List.of(nacionalidade));
        List<NacionalidadeDto> response = nacionalidadeService.getAllNacionalidades();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(nacionalidadeDTO, response.get(0));
        assertEquals(NacionalidadeDto.class, response.get(0).getClass());
        assertEquals(1L, response.get(0).getId());
        assertEquals("Brasileiro", response.get(0).getNome());
    }

    @Test
    void whenFindAllThenReturnAnListEmpty() {
        when(nacionalidadeRepository.findAll()).thenReturn(new ArrayList<>());
        List<NacionalidadeDto> response = nacionalidadeService.getAllNacionalidades();

        assertTrue(response.isEmpty());
    }
}