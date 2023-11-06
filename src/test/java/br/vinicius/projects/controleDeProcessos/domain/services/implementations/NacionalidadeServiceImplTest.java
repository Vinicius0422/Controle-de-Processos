package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.nacionalidade.NacionalidadeDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.Nacionalidade;
import br.vinicius.projects.controleDeProcessos.repositories.NacionalidadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class NacionalidadeServiceImplTest {

    @Test
    void startNacionalidade(){
        nacionalidade = new Nacionalidade(1L, "Brasileiro");
        nacionalidadeDto = new NacionalidadeDto(1L, "Brasileiro");
    }

    @Mock
    private NacionalidadeRepository nacionalidadeRepository;

    @Autowired
    @InjectMocks
    private NacionalidadeServiceImpl nacionalidadeService;

    private Nacionalidade nacionalidade;
    private NacionalidadeDto nacionalidadeDto;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startNacionalidade();
    }

    @Test
    void whenFindAllThenReturnAnListOfNacionalidades() {
        when(nacionalidadeRepository.findAll()).thenReturn(List.of(nacionalidade));
        List<NacionalidadeDto> response = nacionalidadeService.getAllNacionalidades();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(NacionalidadeDto.class, response.get(0).getClass());
        assertEquals(nacionalidadeDto, response.get(0));
        assertEquals(1L, response.get(0).getId());
        assertEquals("Brasileiro", response.get(0).getNome());
    }
}