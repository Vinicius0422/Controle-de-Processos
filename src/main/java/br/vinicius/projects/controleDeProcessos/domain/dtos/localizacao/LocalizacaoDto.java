package br.vinicius.projects.controleDeProcessos.domain.dtos.localizacao;

import br.vinicius.projects.controleDeProcessos.domain.entities.EstadoCivil;
import br.vinicius.projects.controleDeProcessos.domain.entities.Localizacao;
import br.vinicius.projects.controleDeProcessos.domain.entities.Processo;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamante;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class LocalizacaoDto {

    private Long id;

    private String nome;

    private List<Processo> processos;

    public LocalizacaoDto(Localizacao localizacao){
        this.id = localizacao.getId();
        this.nome = localizacao.getNome();
        this.processos = localizacao.getProcessos();
    }

    public LocalizacaoDto(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }
}
