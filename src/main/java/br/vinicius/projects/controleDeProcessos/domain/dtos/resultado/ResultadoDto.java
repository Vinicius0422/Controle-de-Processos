package br.vinicius.projects.controleDeProcessos.domain.dtos.resultado;

import br.vinicius.projects.controleDeProcessos.domain.entities.EstadoCivil;
import br.vinicius.projects.controleDeProcessos.domain.entities.Processo;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamante;
import br.vinicius.projects.controleDeProcessos.domain.entities.Resultado;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ResultadoDto {

    private Long id;

    private String nome;

    private List<Processo> processos;

    public ResultadoDto(Resultado resultado){
        this.id = resultado.getId();
        this.nome = resultado.getNome();
        this.processos = resultado.getProcessos();
    }

    public ResultadoDto(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }
}
