package br.vinicius.projects.controleDeProcessos.domain.services.implementations;

import br.vinicius.projects.controleDeProcessos.domain.dtos.ResponseDefault;
import br.vinicius.projects.controleDeProcessos.domain.dtos.anotacao.AnotacaoDto;
import br.vinicius.projects.controleDeProcessos.domain.dtos.estadoCivil.EstadoCivilDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.Anotacao;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.AnotacaoService;
import br.vinicius.projects.controleDeProcessos.domain.services.interfaces.EstadoCivilService;
import br.vinicius.projects.controleDeProcessos.repositories.AnotacaoRepository;
import br.vinicius.projects.controleDeProcessos.repositories.EstadoCivilRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AnotacaoServiceImpl implements AnotacaoService {

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @Override
    public List<AnotacaoDto> getAllAnotacao(){
        return anotacaoRepository.findAll().stream().map(AnotacaoDto::new).toList();
    }

    @Override
    public ResponseDefault saveAnotacao(AnotacaoDto anotacaoDto) {
        List<String> validacao = new ArrayList<>();
        if(anotacaoDto.getDataAnotacao() == null || anotacaoDto.getDataAnotacao().equals("")){
            validacao.add("O campo Data é obrigatório!");
        }
        if(anotacaoDto.getAnotacao().isBlank()){
            validacao.add("O campo de anotação é obrigatório!");
        }
        if(!validacao.isEmpty()){
            return new ResponseDefault(409, validacao);
        }
        Anotacao anotacao = new Anotacao();
        BeanUtils.copyProperties(anotacaoDto, anotacao);
        anotacaoRepository.save(anotacao);
        return new ResponseDefault(201, Collections.singletonList("Anotação salva com sucesso!"));
    }

    @Override
    public ResponseDefault updateAnotacao(Long id, AnotacaoDto anotacaoDto) {
        Anotacao anotacao = anotacaoRepository.findById(id).orElse(null);
        if(anotacao == null){
            return new ResponseDefault(404, Collections.singletonList("Nenhum registro encontrado com este ID!"));
        }
        anotacao.setDataAnotacao(anotacaoDto.getDataAnotacao());
        anotacao.setAnotacao(anotacao.getAnotacao());
        anotacaoRepository.save(anotacao);
        return new ResponseDefault(200, Collections.singletonList("Atualizado com sucesso!"));
    }
}
