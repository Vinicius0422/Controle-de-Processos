package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.ResponseDefault;
import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamante.ReclamanteDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamante;
import br.vinicius.projects.controleDeProcessos.repositories.ReclamanteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ReclamanteServiceImplTest {

    void startReclamante(){
        reclamante = new Reclamante(1L, "Vinicius", new Date(2001/04/22) ,"Programador",
                "000.000", "00012", "0.000.000", "SSP/DF", "000.000.000-00", "00", "Rua teste",
                "Brasília", "Teste", "DF", "00.000-000", "NuBank", "0000", "41", "00000-0",
                "(00)99999-9999", "teste@teste.com", null, null, null);
        reclamanteDto = new ReclamanteDto(1L, "Vinicius", new Date(2001/04/22) ,"Programador",
                "000.000", "00012", "0.000.000", "SSP/DF", "000.000.000-00", "00", "Rua teste",
                "Brasília", "Teste", "DF", "00.000-000", "NuBank", "0000", "41", "00000-0",
                "(00)99999-9999", "teste@teste.com", null, null, null);
        reclamanteDtoErros = new ReclamanteDto(1L, "Vinicius", new Date(2001/04/22) ,"Programador",
                "", "", "0.000.000", "SSP/DF", "", "00", "",
                "Brasília", "Teste", "DF", "00.000-000", "NuBank", "0000", "41", "00000-0",
                "(00)99999-9999", "teste@teste.com", null, null, null);
    }

    @Mock
    private ReclamanteRepository reclamanteRepository;

    @Autowired
    @InjectMocks
    private ReclamanteServiceImpl reclamanteService;

    List list = new ArrayList();
    private Reclamante reclamante;
    private ReclamanteDto reclamanteDto;

    private ReclamanteDto reclamanteDtoErros;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startReclamante();
    }

    @Test
    void whenFindAllThenReturnAnListOfReclamantes() {
        when(reclamanteRepository.findAll()).thenReturn(List.of(reclamante));
        List<ReclamanteDto> response = reclamanteService.getAllReclamantes();

        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(1, response.size());
        assertEquals(reclamanteDto, response.get(0));
        assertEquals(ReclamanteDto.class, response.get(0).getClass());
        assertEquals(1L, response.get(0).getId());
        assertEquals("Vinicius", response.get(0).getNome());
        assertEquals(new Date(2001/04/22), response.get(0).getDataNascimento());
        assertEquals("Programador", response.get(0).getProfissao());
        assertEquals("000.000", response.get(0).getCtps());
        assertEquals("00012", response.get(0).getSerieCtps());
        assertEquals("0.000.000", response.get(0).getRg());
        assertEquals("SSP/DF", response.get(0).getOrgaoRg());
        assertEquals("000.000.000-00", response.get(0).getCpf());
        assertEquals("00", response.get(0).getPis());
        assertEquals("Rua teste", response.get(0).getEndereco());
        assertEquals("Brasília", response.get(0).getCidade());
        assertEquals("Teste", response.get(0).getBairro());
        assertEquals("DF", response.get(0).getUf());
        assertEquals("00.000-000", response.get(0).getCep());
        assertEquals("NuBank", response.get(0).getBanco());
        assertEquals("0000", response.get(0).getAgencia());
        assertEquals("41", response.get(0).getOperacao());
        assertEquals("00000-0", response.get(0).getConta());
        assertEquals("(00)99999-9999", response.get(0).getContato());
        assertEquals("teste@teste.com", response.get(0).getEmail());
    }

    @Test
    void whenFindAllThenReturnAnEmptyList() {
        when(reclamanteRepository.findAll()).thenReturn(list);
        List response = reclamanteService.getAllReclamantes();

        assertNotNull(response);
        assertTrue(response.isEmpty());
    }

    @Test
    void whenFindByIdExistent() {
        when(reclamanteRepository.findById(1L)).thenReturn(Optional.ofNullable(reclamante));
        ReclamanteDto response = reclamanteService.getById(1L);

        assertNotNull(response);
        assertEquals(reclamanteDto, response);
        assertEquals(ReclamanteDto.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals("Vinicius", response.getNome());
        assertEquals(new Date(2001/04/22), response.getDataNascimento());
        assertEquals("Programador", response.getProfissao());
        assertEquals("000.000", response.getCtps());
        assertEquals("00012", response.getSerieCtps());
        assertEquals("0.000.000", response.getRg());
        assertEquals("SSP/DF", response.getOrgaoRg());
        assertEquals("000.000.000-00", response.getCpf());
        assertEquals("00", response.getPis());
        assertEquals("Rua teste", response.getEndereco());
        assertEquals("Brasília", response.getCidade());
        assertEquals("Teste", response.getBairro());
        assertEquals("DF", response.getUf());
        assertEquals("00.000-000", response.getCep());
        assertEquals("NuBank", response.getBanco());
        assertEquals("0000", response.getAgencia());
        assertEquals("41", response.getOperacao());
        assertEquals("00000-0", response.getConta());
        assertEquals("(00)99999-9999", response.getContato());
        assertEquals("teste@teste.com", response.getEmail());
    }

    @Test
    void whenFindByIdNonexistent() {
        when(reclamanteRepository.findById(2L)).thenReturn(Optional.empty());
        ReclamanteDto response = reclamanteService.getById(2L);

        assertNull(response);
    }

    @Test
    void whenFindByCpfExistent() {
        when(reclamanteRepository.findByCpf("000.000.000-00")).thenReturn(Optional.ofNullable(reclamante));
        ReclamanteDto response = reclamanteService.getByCpf("000.000.000-00");

        assertNotNull(response);
        assertEquals(reclamanteDto, response);
        assertEquals(ReclamanteDto.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals("Vinicius", response.getNome());
        assertEquals(new Date(2001/04/22), response.getDataNascimento());
        assertEquals("Programador", response.getProfissao());
        assertEquals("000.000", response.getCtps());
        assertEquals("00012", response.getSerieCtps());
        assertEquals("0.000.000", response.getRg());
        assertEquals("SSP/DF", response.getOrgaoRg());
        assertEquals("000.000.000-00", response.getCpf());
        assertEquals("00", response.getPis());
        assertEquals("Rua teste", response.getEndereco());
        assertEquals("Brasília", response.getCidade());
        assertEquals("Teste", response.getBairro());
        assertEquals("DF", response.getUf());
        assertEquals("00.000-000", response.getCep());
        assertEquals("NuBank", response.getBanco());
        assertEquals("0000", response.getAgencia());
        assertEquals("41", response.getOperacao());
        assertEquals("00000-0", response.getConta());
        assertEquals("(00)99999-9999", response.getContato());
        assertEquals("teste@teste.com", response.getEmail());
    }

    @Test
    void whenFindByCpfNonexistent() {
        when(reclamanteRepository.findByCpf("000.000.000-01")).thenReturn(Optional.empty());
        ReclamanteDto response = reclamanteService.getByCpf("000.000.000-01");

        assertNull(response);
    }

    @Test
    void whenFindByNomeContainsExistent() {
        when(reclamanteRepository.findByNomeContains("Vinicius")).thenReturn(List.of(reclamante));
        List<ReclamanteDto> response = reclamanteService.getByNome("Vinicius");

        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(1, response.size());
        assertEquals(reclamanteDto, response.get(0));
        assertEquals(ReclamanteDto.class, response.get(0).getClass());
        assertEquals(1L, response.get(0).getId());
        assertEquals("Vinicius", response.get(0).getNome());
        assertEquals(new Date(2001/04/22), response.get(0).getDataNascimento());
        assertEquals("Programador", response.get(0).getProfissao());
        assertEquals("000.000", response.get(0).getCtps());
        assertEquals("00012", response.get(0).getSerieCtps());
        assertEquals("0.000.000", response.get(0).getRg());
        assertEquals("SSP/DF", response.get(0).getOrgaoRg());
        assertEquals("000.000.000-00", response.get(0).getCpf());
        assertEquals("00", response.get(0).getPis());
        assertEquals("Rua teste", response.get(0).getEndereco());
        assertEquals("Brasília", response.get(0).getCidade());
        assertEquals("Teste", response.get(0).getBairro());
        assertEquals("DF", response.get(0).getUf());
        assertEquals("00.000-000", response.get(0).getCep());
        assertEquals("NuBank", response.get(0).getBanco());
        assertEquals("0000", response.get(0).getAgencia());
        assertEquals("41", response.get(0).getOperacao());
        assertEquals("00000-0", response.get(0).getConta());
        assertEquals("(00)99999-9999", response.get(0).getContato());
        assertEquals("teste@teste.com", response.get(0).getEmail());
    }

    @Test
    void whenFindByNomeContainsNonexistent() {
        when(reclamanteRepository.findByNomeContains("Maria")).thenReturn(list);
        List response = reclamanteService.getByNome("Maria");

        assertNotNull(response);
        assertTrue(response.isEmpty());
    }

    @Test
    void whenSaveReclamanteIsSuccessful() {
        when(reclamanteRepository.save(reclamante)).thenReturn(reclamante);
        ResponseDefault response = reclamanteService.saveReclamante(reclamanteDto);

        assertNotNull(response);
        assertEquals(ResponseDefault.class, response.getClass());
        assertEquals(201, response.getStatusCode());
        assertEquals(1, response.getMensagens().size());
        assertEquals("Criando com sucesso!", response.getMensagens().get(0));
    }

    @Test
    void whenSaveReclamanteIsUnsuccessfulDueValidation() {
        ResponseDefault response = reclamanteService.saveReclamante(reclamanteDtoErros);

        assertNotNull(response);
        assertEquals(ResponseDefault.class, response.getClass());
        assertEquals(409, response.getStatusCode());
        assertEquals(4, response.getMensagens().size());
        assertTrue(response.getMensagens().contains("O campo CTPS é obrigatório!"));
        assertTrue(response.getMensagens().contains("O campo Serie CTPS é obrigatório!"));
        assertTrue(response.getMensagens().contains("O campo CPF é obrigatório!"));
        assertTrue(response.getMensagens().contains("O campo Endereço é obrigatório!"));
    }

    @Test
    void WhenUpdateReclamanteIsSuccessful() {
        when(reclamanteRepository.save(reclamante)).thenReturn(reclamante);
        ResponseDefault response = reclamanteService.updateReclamante(1L, reclamanteDto);

        assertNotNull(response);
        assertEquals(ResponseDefault.class, response.getClass());
        assertEquals(200, response.getStatusCode());
        assertEquals(1, response.getMensagens().size());
        assertEquals("Atualizado com sucesso!", response.getMensagens().get(0));
    }

    @Test
    void WhenUpdateReclamanteIsUnsuccessfulDueValidation() {
        ResponseDefault response = reclamanteService.updateReclamante(1L, reclamanteDtoErros);

        assertNotNull(response);
        assertEquals(ResponseDefault.class, response.getClass());
        assertEquals(409, response.getStatusCode());
        assertEquals(4, response.getMensagens().size());
        assertTrue(response.getMensagens().contains("O campo CTPS é obrigatório!"));
        assertTrue(response.getMensagens().contains("O campo Serie CTPS é obrigatório!"));
        assertTrue(response.getMensagens().contains("O campo CPF é obrigatório!"));
        assertTrue(response.getMensagens().contains("O campo Endereço é obrigatório!"));
    }

    @Test
    void whenValidacaoReclamanteDTOIsSuccessful() {
        when(reclamanteRepository.existsByCpf(reclamanteDto.getCpf())).thenReturn(false);
        when(reclamanteRepository.existsByRgAndOrgaoRg(reclamanteDto.getRg(), reclamanteDto.getOrgaoRg())).thenReturn(false);
        when(reclamanteRepository.existsByBancoAndAgenciaAndConta(reclamanteDto.getBanco(), reclamanteDto.getAgencia(), reclamanteDto.getConta())).thenReturn(false);

        List<String> response = reclamanteService.validacaoReclamanteDTO(reclamanteDto);
        assertTrue(response.isEmpty());
    }

    @Test
    void whenValidacaoReclamanteDTOIsUnsuccessful() {
        when(reclamanteRepository.existsByRgAndOrgaoRg(reclamanteDto.getRg(), reclamanteDto.getOrgaoRg())).thenReturn(true);
        when(reclamanteRepository.existsByBancoAndAgenciaAndConta(reclamanteDto.getBanco(), reclamanteDto.getAgencia(), reclamanteDto.getConta())).thenReturn(true);
        List<String> response = reclamanteService.validacaoReclamanteDTO(reclamanteDtoErros);

        assertFalse(response.isEmpty());
        assertEquals(6, response.size());
        assertTrue(response.contains("O campo CTPS é obrigatório!"));
        assertTrue(response.contains("O campo Serie CTPS é obrigatório!"));
        assertTrue(response.contains("O campo CPF é obrigatório!"));
        assertTrue(response.contains("O campo Endereço é obrigatório!"));
        assertTrue(response.contains("RG já cadastrado!"));
        assertTrue(response.contains("Conta Bancária já cadastrada!"));
    }

    @Test
    void whenValidacaoUpdateReclamanteDTOIsSuccessful() {
        when(reclamanteRepository.existsByCpf(reclamanteDto.getCpf())).thenReturn(true);
        when(reclamanteRepository.findByCpfEquals(reclamanteDto.getCpf())).thenReturn(1L);
        when(reclamanteRepository.existsByRgAndOrgaoRg(reclamanteDto.getRg(), reclamanteDto.getOrgaoRg())).thenReturn(true);
        when(reclamanteRepository.findByRgAndOrgaoRgEquals(reclamanteDto.getRg(), reclamanteDto.getOrgaoRg())).thenReturn(1L);
        when(reclamanteRepository.existsByBancoAndAgenciaAndConta(reclamanteDto.getBanco(), reclamanteDto.getAgencia(), reclamanteDto.getConta())).thenReturn(true);
        when(reclamanteRepository.findByBancoAndAgenciaAndContaEquals(reclamanteDto.getBanco(), reclamanteDto.getAgencia(), reclamanteDto.getConta())).thenReturn(1L);
        List<String> response = reclamanteService.validacaoUpdateReclamanteDTO(1L, reclamanteDto);
        assertTrue(response.isEmpty());
    }

    @Test
    void whenValidacaoUpdateReclamanteDTOIsUnsuccessful() {
        when(reclamanteRepository.existsByRgAndOrgaoRg(reclamanteDto.getRg(), reclamanteDto.getOrgaoRg())).thenReturn(true);
        when(reclamanteRepository.findByRgAndOrgaoRgEquals(reclamanteDto.getRg(), reclamanteDto.getOrgaoRg())).thenReturn(2L);
        when(reclamanteRepository.existsByBancoAndAgenciaAndConta(reclamanteDto.getBanco(), reclamanteDto.getAgencia(), reclamanteDto.getConta())).thenReturn(true);
        when(reclamanteRepository.findByBancoAndAgenciaAndContaEquals(reclamanteDto.getBanco(), reclamanteDto.getAgencia(), reclamanteDto.getConta())).thenReturn(2L);
        List<String> response = reclamanteService.validacaoUpdateReclamanteDTO(1L, reclamanteDtoErros);

        assertFalse(response.isEmpty());
        assertEquals(6, response.size());
        assertTrue(response.contains("O campo CTPS é obrigatório!"));
        assertTrue(response.contains("O campo Serie CTPS é obrigatório!"));
        assertTrue(response.contains("O campo CPF é obrigatório!"));
        assertTrue(response.contains("O campo Endereço é obrigatório!"));
        assertTrue(response.contains("RG já cadastrado!"));
        assertTrue(response.contains("Conta Bancária já cadastrada!"));
    }
}