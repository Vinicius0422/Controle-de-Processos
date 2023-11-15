package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.ResponseDefault;
import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamante.ReclamanteDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamante;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.ReclamanteService;
import br.vinicius.projects.controleDeProcessos.repositories.ReclamanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReclamanteServiceImpl implements ReclamanteService {

    @Autowired
    private ReclamanteRepository reclamanteRepository;

    @Override
    public List<ReclamanteDto> getAllReclamantes() {
        return reclamanteRepository.findAll().stream().map(ReclamanteDto::new).toList();
    }

    @Override
    public ReclamanteDto getById(Long id) {
        Reclamante reclamante = reclamanteRepository.findById(id).orElse(null);
        if(reclamante == null){
            return null;
        }
        return new ReclamanteDto(reclamante);
    }

    @Override
    public ReclamanteDto getByCpf(String cpf) {
        Reclamante reclamante = reclamanteRepository.findByCpf(cpf).orElse(null);
        if(reclamante == null){
            return null;
        }
        return new ReclamanteDto(reclamante);
    }

    @Override
    public List<ReclamanteDto> getByNome(String nome) {
        return reclamanteRepository.findByNomeContains(nome).stream().map(ReclamanteDto::new).toList();
    }

    @Override
    @Transactional
    public ResponseDefault saveReclamante(ReclamanteDto reclamanteDto) {
        // DataIntegrityViolationException, illegalargumentexception , ConstraintViolationException
        var validacao = validacaoReclamanteDTO(reclamanteDto);
        if(!validacao.isEmpty()){
            return new ResponseDefault(409, validacao);
        }
        Reclamante reclamante = new Reclamante();
        BeanUtils.copyProperties(reclamanteDto, reclamante);
        reclamanteRepository.save(reclamante);
        return new ResponseDefault(201, Collections.singletonList("Criado com sucesso!"));
    }

    @Override
    public ResponseDefault updateReclamante(Long id, ReclamanteDto reclamanteDto) {
        var validacao = validacaoUpdateReclamanteDTO(id, reclamanteDto);
        if(!validacao.isEmpty()){
            return new ResponseDefault(409, validacao);
        }
        Reclamante reclamanteUpdate = new Reclamante();
        BeanUtils.copyProperties(reclamanteDto, reclamanteUpdate);
        reclamanteRepository.save(reclamanteUpdate);
        return new ResponseDefault(200, Collections.singletonList("Atualizado com sucesso!"));
    }

    public List<String> validacaoReclamanteDTO(ReclamanteDto reclamanteDto){
        List<String> erros = new ArrayList<>();
        if(reclamanteDto.getNome().isBlank()){
            erros.add("O campo Nome é obrigatório!");
        }
        if(reclamanteDto.getCtps().isBlank()){
            erros.add("O campo CTPS é obrigatório!");
        }
        if(reclamanteDto.getSerieCtps().isBlank()){
            erros.add("O campo Serie CTPS é obrigatório!");
        }
        if(reclamanteDto.getRg().isBlank()){
            erros.add("O campo Rg é obrigatório!");
        }
        if(reclamanteDto.getOrgaoRg().isBlank()){
            erros.add("O campo Órgão expedição é obrigatório!");
        }
        if(reclamanteDto.getCpf().isBlank()){
            erros.add("O campo CPF é obrigatório!");
        }
        if (reclamanteDto.getEndereco().isBlank()) {
            erros.add("O campo Endereço é obrigatório!");
        }
        if (reclamanteDto.getCidade().isBlank()) {
            erros.add("O campo Cidade é obrigatório!");
        }
        if(reclamanteDto.getBairro().isBlank()){
            erros.add("O campo Bairro é obrigatório!");
        }
        if(reclamanteDto.getUf().isBlank()){
            erros.add("O campo UF é obrigatório!");
        }
        if (reclamanteDto.getCep().isBlank()) {
            erros.add("O campo CEP é obrigatório!");
        }
        if (reclamanteDto.getContato().isBlank()) {
            erros.add("O campo Contatos é obrigatório!");
        }
        if (reclamanteRepository.existsByCpf(reclamanteDto.getCpf())){
            erros.add("CPF já cadastrado!");
        }
        if(reclamanteRepository.existsByRgAndOrgaoRg(reclamanteDto.getRg(), reclamanteDto.getOrgaoRg())){
            erros.add("RG já cadastrado!");
        }
        if(reclamanteRepository.existsByBancoAndAgenciaAndConta(reclamanteDto.getBanco(), reclamanteDto.getAgencia(), reclamanteDto.getConta())){
            erros.add("Conta Bancária já cadastrada!");
        }
        return erros;
    }

    public List<String> validacaoUpdateReclamanteDTO(Long id, ReclamanteDto reclamanteDto){
        List<String> erros = new ArrayList<>();
        if(reclamanteDto.getNome().isBlank()){
            erros.add("O campo Nome é obrigatório!");
        }
        if(reclamanteDto.getCtps().isBlank()){
            erros.add("O campo CTPS é obrigatório!");
        }
        if(reclamanteDto.getSerieCtps().isBlank()){
            erros.add("O campo Serie CTPS é obrigatório!");
        }
        if(reclamanteDto.getRg().isBlank()){
            erros.add("O campo Rg é obrigatório!");
        }
        if(reclamanteDto.getOrgaoRg().isBlank()){
            erros.add("O campo Órgão expedição é obrigatório!");
        }
        if(reclamanteDto.getCpf().isBlank()){
            erros.add("O campo CPF é obrigatório!");
        }
        if (reclamanteDto.getEndereco().isBlank()) {
            erros.add("O campo Endereço é obrigatório!");
        }
        if (reclamanteDto.getCidade().isBlank()) {
            erros.add("O campo Cidade é obrigatório!");
        }
        if(reclamanteDto.getBairro().isBlank()){
            erros.add("O campo Bairro é obrigatório!");
        }
        if(reclamanteDto.getUf().isBlank()){
            erros.add("O campo UF é obrigatório!");
        }
        if (reclamanteDto.getCep().isBlank()) {
            erros.add("O campo CEP é obrigatório!");
        }
        if (reclamanteDto.getContato().isBlank()) {
            erros.add("O campo Contatos é obrigatório!");
        }
        boolean cpfCheck = reclamanteRepository.existsByCpf(reclamanteDto.getCpf());
        if(cpfCheck) {
            Long cpfId = reclamanteRepository.findByCpfEquals(reclamanteDto.getCpf());
            if (cpfId != id) {
                erros.add("CPF já cadastrado!");
            }
        }
        boolean rgCheck = reclamanteRepository.existsByRgAndOrgaoRg(reclamanteDto.getRg(), reclamanteDto.getOrgaoRg());
        if(rgCheck) {
            Long rgId = reclamanteRepository.findByRgAndOrgaoRgEquals(reclamanteDto.getRg(), reclamanteDto.getOrgaoRg());
            if (rgId != id) {
                erros.add("RG já cadastrado!");
            }
        }
        boolean contaBancoCheck = reclamanteRepository.existsByBancoAndAgenciaAndConta(reclamanteDto.getBanco(), reclamanteDto.getAgencia(), reclamanteDto.getConta());
        if(contaBancoCheck) {
            Long contaId = reclamanteRepository.findByBancoAndAgenciaAndContaEquals(reclamanteDto.getBanco(), reclamanteDto.getAgencia(), reclamanteDto.getConta());
            if (contaId != id) {
                erros.add("Conta Bancária já cadastrada!");
            }
        }
        return erros;
    }
}
