package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.ResponseDefault;
import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamado.ReclamadoDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamado;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.ReclamadoServiceIntfc;
import br.vinicius.projects.controleDeProcessos.repositories.ReclamadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ReclamadoServiceImpl implements ReclamadoServiceIntfc {

    @Autowired
    private ReclamadoRepository reclamadoRepository;

    @Override
    public List<ReclamadoDto> getAllReclamados() {
        return reclamadoRepository.findAll().stream().map(ReclamadoDto::new).toList();
    }

    @Override
    public ReclamadoDto getById(Long id) {
        Reclamado reclamado = reclamadoRepository.findById(id).orElse(null);
        if(reclamado == null){
            return null;
        }
        return new ReclamadoDto(reclamado);
    }

    @Override
    public ReclamadoDto getByCpfOuCnpj(String cpf_cnpj) {
        Reclamado reclamado = reclamadoRepository.findByCpf_Cnpj(cpf_cnpj).orElse(null);
        if(reclamado == null){
            return null;
        }
        return new ReclamadoDto(reclamado);
    }

    @Override
    public List<ReclamadoDto> getByNome(String nome) {
        return reclamadoRepository.findByNomeContains(nome).stream().map(ReclamadoDto::new).toList();
    }

    @Override
    public ResponseDefault saveReclamado(ReclamadoDto reclamadoDto) {
        List<String> validacao = validacaoReclamadoDTO(reclamadoDto);
        if(!validacao.isEmpty()){
            return new ResponseDefault(409, validacao);
        }
        Reclamado reclamado = new Reclamado();
        BeanUtils.copyProperties(reclamadoDto, reclamado);
        reclamadoRepository.save(reclamado);
        return new ResponseDefault(201, Collections.singletonList("Criado com sucesso!"));
    }

    @Override
    public ResponseDefault updateReclamado(Long id, ReclamadoDto reclamadoDto) {
        List<String> validacao = validacaoUpdateReclamadoDTO(id, reclamadoDto);
        if(!validacao.isEmpty()){
            return new ResponseDefault(409, validacao);
        }
        Reclamado reclamadoToUpdate = new Reclamado();
        BeanUtils.copyProperties(reclamadoDto, reclamadoToUpdate);
        reclamadoRepository.save(reclamadoToUpdate);
        return new ResponseDefault(200, Collections.singletonList("Atualizado com sucesso!"));
    }
    public List<String> validacaoReclamadoDTO(ReclamadoDto reclamadoDto){
        List<String> erros = new ArrayList<>();
        if(reclamadoDto.getNome().isBlank()){
            erros.add("O campo nome é obrigatório!");
        }
        if(reclamadoDto.getCpf_cnpj().isBlank()){
            erros.add("O campo CPF/CNPJ é obrigatório!");
        }
        if(reclamadoRepository.existsByCpf_Cnpj(reclamadoDto.getCpf_cnpj())){
            erros.add("CPF/CNPJ já cadastrado!");
        }
        return erros;
    }
    public List<String> validacaoUpdateReclamadoDTO(Long id, ReclamadoDto reclamadoDto){
        List<String> erros = new ArrayList<>();
        if(reclamadoDto.getNome().isBlank()){
            erros.add("O campo nome é obrigatório!");
        }
        if(reclamadoDto.getCpf_cnpj().isBlank()){
            erros.add("O campo CPF/CNPJ é obrigatório!");
        }
        boolean cpfCnpjCheck = reclamadoRepository.existsByCpf_Cnpj(reclamadoDto.getCpf_cnpj());
        if(cpfCnpjCheck){
            Long cpfCnpjId = reclamadoRepository.findByCpf_CnpjEquals(reclamadoDto.getCpf_cnpj());
            if(id != cpfCnpjId) {
                erros.add("CPF/CNPJ já cadastrado!");
            }
        }
        return erros;
    }
}
