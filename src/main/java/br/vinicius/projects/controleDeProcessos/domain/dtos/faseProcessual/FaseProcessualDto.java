package br.vinicius.projects.controleDeProcessos.domain.dtos.faseProcessual;

import br.vinicius.projects.controleDeProcessos.domain.entities.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FaseProcessualDto {

    private Long id;

    private String nome;

    private List<Andamento> andamentos;
    private List<Processo> processos;

    public FaseProcessualDto(FaseProcessual faseProcessual){
        this.id = faseProcessual.getId();
        this.nome = faseProcessual.getNome();
        this.andamentos = faseProcessual.getAndamentos();
        this.processos = faseProcessual.getProcessos();
    }

    public FaseProcessualDto(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }
}
