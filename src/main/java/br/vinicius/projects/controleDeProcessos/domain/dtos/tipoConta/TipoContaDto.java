package br.vinicius.projects.controleDeProcessos.domain.dtos.tipoConta;

import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamante.ReclamanteDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamante;
import br.vinicius.projects.controleDeProcessos.domain.entities.TipoConta;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TipoContaDto {

    private Long id;

    private String nome;

    private List<Reclamante> reclamantes;
    public TipoContaDto(TipoConta tipoConta){
        this.id = tipoConta.getId();
        this.nome = tipoConta.getNome();
        this.reclamantes = tipoConta.getReclamantes();
    }

    public TipoContaDto(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }
}
