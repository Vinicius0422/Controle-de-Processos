package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.ResponseDefault;
import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamado.ReclamadoDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamante.ReclamanteDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.FaseProcessual;
import br.vinicius.projects.controleDeProcessos.domain.entities.Processo;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamado;
import br.vinicius.projects.controleDeProcessos.domain.entities.TipoPessoa;
import br.vinicius.projects.controleDeProcessos.repositories.ReclamadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ReclamadoServiceImplTest {

    @Mock
    private ReclamadoRepository reclamadoRepository;

    @Autowired
    @InjectMocks
    private ReclamadoServiceImpl reclamadoService;

    private ReclamadoDto reclamadoDto;
    private Reclamado reclamado;
    private ReclamadoDto reclamadoDtoErros;
    private ReclamadoDto reclamadoValidate;
    private Processo processo = new Processo();
    void startReclamado(){
        reclamadoDto = new ReclamadoDto(1L, "Teste", TipoPessoa.FISICA, "000.000.000-00",
                "Teste 123", "Brasilia", "Bairro", "DF", "00.000-00", "0",
                "teste@teste.com.br", Collections.singletonList(processo));
        reclamado = new Reclamado(1L, "Teste", TipoPessoa.FISICA, "000.000.000-00",
                "Teste 123", "Brasilia", "Bairro", "DF", "00.000-00", "0",
                "teste@teste.com.br", Collections.singletonList(processo));
        reclamadoDtoErros = new ReclamadoDto(1L, "", TipoPessoa.FISICA, "",
                "Teste 123", "Brasilia", "Bairro", "DF", "00.000-00", "0",
                "teste@teste.com.br", Collections.singletonList(processo));
        reclamadoValidate = new ReclamadoDto(1L, "", TipoPessoa.FISICA, "000.000.000-00",
                "Teste 123", "Brasilia", "Bairro", "DF", "00.000-00", "0",
                "teste@teste.com.br", Collections.singletonList(processo));
    }

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startReclamado();
    }


    @Test
    void whenFindAllThenReturnAnListOfReclamados() {
        when(reclamadoRepository.findAll()).thenReturn(List.of(reclamado));
        List<ReclamadoDto> response = reclamadoService.getAllReclamados();

        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(1, response.size());
        assertEquals(ReclamadoDto.class, response.get(0).getClass());
        assertEquals(1L, response.get(0).getId());
        assertEquals("Teste", response.get(0).getNome());
        assertEquals(TipoPessoa.FISICA, response.get(0).getTipoPessoa());
        assertEquals("000.000.000-00", response.get(0).getCpf_cnpj());
        assertEquals("Teste 123", response.get(0).getEndereco());
        assertEquals("Brasilia", response.get(0).getCidade());
        assertEquals("Bairro", response.get(0).getBairro());
        assertEquals("DF", response.get(0).getUf());
        assertEquals("00.000-00", response.get(0).getCep());
        assertEquals("0", response.get(0).getContato());
        assertEquals("teste@teste.com.br", response.get(0).getEmail());
        assertEquals(Processo.class, response.get(0).getProcessos().get(0).getClass());
        assertFalse(response.get(0).getProcessos().isEmpty());
        assertEquals(1, response.get(0).getProcessos().size());
    }

    @Test
    void whenFindAllThenReturnAnEmptyList(){
        when(reclamadoRepository.findAll()).thenReturn(new ArrayList<>());
        List response = reclamadoService.getAllReclamados();

        assertNotNull(response);
        assertTrue(response.isEmpty());
    }

    @Test
    void whenFindByIdExistent() {
        when(reclamadoRepository.findById(1L)).thenReturn(Optional.ofNullable(reclamado));
        ReclamadoDto response = reclamadoService.getById(1L);

        assertNotNull(response);
        assertEquals(reclamadoDto, response);
        assertEquals(ReclamadoDto.class, response.getClass());
        assertEquals(ReclamadoDto.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals("Teste", response.getNome());
        assertEquals(TipoPessoa.FISICA, response.getTipoPessoa());
        assertEquals("000.000.000-00", response.getCpf_cnpj());
        assertEquals("Teste 123", response.getEndereco());
        assertEquals("Brasilia", response.getCidade());
        assertEquals("Bairro", response.getBairro());
        assertEquals("DF", response.getUf());
        assertEquals("00.000-00", response.getCep());
        assertEquals("0", response.getContato());
        assertEquals("teste@teste.com.br", response.getEmail());
        assertEquals(Processo.class, response.getProcessos().get(0).getClass());
        assertFalse(response.getProcessos().isEmpty());
        assertEquals(1, response.getProcessos().size());
    }

    @Test
    void whenFindByIdNonexistent() {
        when(reclamadoRepository.findById(2L)).thenReturn(Optional.empty());
        ReclamadoDto response = reclamadoService.getById(2L);

        assertNull(response);
    }

    @Test
    void whenFindByCpfOrCnpjExistent() {
        when(reclamadoRepository.findByCpfCnpj("000.000.000-00")).thenReturn(Optional.ofNullable(reclamado));
        ReclamadoDto response = reclamadoService.getByCpfOuCnpj("000.000.000-00");

        assertNotNull(response);
        assertEquals(reclamadoDto, response);
        assertEquals(ReclamadoDto.class, response.getClass());
        assertEquals(ReclamadoDto.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals("Teste", response.getNome());
        assertEquals(TipoPessoa.FISICA, response.getTipoPessoa());
        assertEquals("000.000.000-00", response.getCpf_cnpj());
        assertEquals("Teste 123", response.getEndereco());
        assertEquals("Brasilia", response.getCidade());
        assertEquals("Bairro", response.getBairro());
        assertEquals("DF", response.getUf());
        assertEquals("00.000-00", response.getCep());
        assertEquals("0", response.getContato());
        assertEquals("teste@teste.com.br", response.getEmail());
        assertEquals(Processo.class, response.getProcessos().get(0).getClass());
        assertFalse(response.getProcessos().isEmpty());
        assertEquals(1, response.getProcessos().size());
    }

    @Test
    void whenFindByCpfOrCnpjNonexistent() {
        when(reclamadoRepository.findByCpfCnpj("000.000.000-01")).thenReturn(Optional.empty());
        ReclamadoDto response = reclamadoService.getByCpfOuCnpj("000.000.000-01");

        assertNull(response);
    }

    @Test
    void whenFindByNomeContainsExistent() {
        when(reclamadoRepository.findByNomeContains("Teste")).thenReturn(List.of(reclamado));
        List<ReclamadoDto> response = reclamadoService.getByNome("Teste");

        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(1, response.size());
        assertEquals(ReclamadoDto.class, response.get(0).getClass());
        assertEquals(1L, response.get(0).getId());
        assertEquals("Teste", response.get(0).getNome());
        assertEquals(TipoPessoa.FISICA, response.get(0).getTipoPessoa());
        assertEquals("000.000.000-00", response.get(0).getCpf_cnpj());
        assertEquals("Teste 123", response.get(0).getEndereco());
        assertEquals("Brasilia", response.get(0).getCidade());
        assertEquals("Bairro", response.get(0).getBairro());
        assertEquals("DF", response.get(0).getUf());
        assertEquals("00.000-00", response.get(0).getCep());
        assertEquals("0", response.get(0).getContato());
        assertEquals("teste@teste.com.br", response.get(0).getEmail());
        assertEquals(Processo.class, response.get(0).getProcessos().get(0).getClass());
        assertFalse(response.get(0).getProcessos().isEmpty());
        assertEquals(1, response.get(0).getProcessos().size());
    }

    @Test
    void whenFindByNomeContainsNonexistent() {
        when(reclamadoRepository.findByNomeContains("Maria")).thenReturn(new ArrayList<>());
        List response = reclamadoService.getByNome("Maria");

        assertNotNull(response);
        assertTrue(response.isEmpty());
    }

    @Test
    void whenSaveReclamadoIsSuccessful() {
        when(reclamadoRepository.save(reclamado)).thenReturn(reclamado);
        ResponseDefault response = reclamadoService.saveReclamado(reclamadoDto);

        assertNotNull(response);
        assertEquals(ResponseDefault.class, response.getClass());
        assertEquals(201, response.getStatusCode());
        assertEquals(1, response.getMensagens().size());
        assertEquals("Criado com sucesso!", response.getMensagens().get(0));
    }

    @Test
    void whenSaveReclamadoIsUnsuccessfulDueValidation() {
        ResponseDefault response = reclamadoService.saveReclamado(reclamadoDtoErros);

        assertNotNull(response);
        assertEquals(ResponseDefault.class, response.getClass());
        assertEquals(409, response.getStatusCode());
        assertEquals(2, response.getMensagens().size());
        assertTrue(response.getMensagens().contains("O campo nome é obrigatório!"));
        assertTrue(response.getMensagens().contains("O campo CPF/CNPJ é obrigatório!"));
    }

    @Test
    void WhenUpdateReclamadoIsSuccessful() {
        when(reclamadoRepository.save(reclamado)).thenReturn(reclamado);
        ResponseDefault response = reclamadoService.updateReclamado(1L, reclamadoDto);

        assertNotNull(response);
        assertEquals(ResponseDefault.class, response.getClass());
        assertEquals(200, response.getStatusCode());
        assertEquals(1, response.getMensagens().size());
        assertEquals("Atualizado com sucesso!", response.getMensagens().get(0));
    }

    @Test
    void WhenUpdateReclamanteIsUnsuccessfulDueValidation() {
        ResponseDefault response = reclamadoService.updateReclamado(1L, reclamadoDtoErros);

        assertNotNull(response);
        assertEquals(ResponseDefault.class, response.getClass());
        assertEquals(409, response.getStatusCode());
        assertEquals(2, response.getMensagens().size());
        assertTrue(response.getMensagens().contains("O campo nome é obrigatório!"));
        assertTrue(response.getMensagens().contains("O campo CPF/CNPJ é obrigatório!"));
    }

    @Test
    void whenValidacaoReclamadoDTOReturnOk() {
        when(reclamadoRepository.existsByCpfCnpj(reclamadoDto.getCpf_cnpj())).thenReturn(false);
        List<String> response = reclamadoService.validacaoReclamadoDTO(reclamadoDto);

        assertTrue(response.isEmpty());
    }

    @Test
    void whenValidacaoReclamanteDTOReturnError() {
        when(reclamadoRepository.existsByCpfCnpj(reclamadoValidate.getCpf_cnpj())).thenReturn(true);
        List<String> response =  reclamadoService.validacaoReclamadoDTO(reclamadoValidate);

        assertFalse(response.isEmpty());
        assertEquals(2, response.size());
        assertTrue(response.contains("O campo nome é obrigatório!"));
        assertTrue(response.contains("CPF/CNPJ já cadastrado!"));
    }

    @Test
    void whenValidacaoUpdateReclamadoDTOReturnOk() {
        when(reclamadoRepository.existsByCpfCnpj(reclamadoDto.getCpf_cnpj())).thenReturn(true);
        when(reclamadoRepository.findByCpfCnpjEquals(reclamadoDto.getCpf_cnpj())).thenReturn(1L);
        List<String> response = reclamadoService.validacaoUpdateReclamadoDTO(1L, reclamadoDto);

        assertTrue(response.isEmpty());
    }

    @Test
    void whenValidacaoUpdateReclamadoDTOReturnError() {
        when(reclamadoRepository.existsByCpfCnpj(reclamadoDto.getCpf_cnpj())).thenReturn(true);
        when(reclamadoRepository.findByCpfCnpjEquals(reclamadoDto.getCpf_cnpj())).thenReturn(2L);
        List<String> response = reclamadoService.validacaoUpdateReclamadoDTO(1L, reclamadoDto);

        assertFalse(response.isEmpty());
        assertEquals(1, response.size());
        assertTrue(response.contains("CPF/CNPJ já cadastrado!"));
    }
}