package br.vinicius.projects.controleDeProcessos.domain.dtos.estadoCivil;

import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamante.ReclamanteDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.EstadoCivil;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamante;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EstadoCivilDto {

    private Long id;

    private String nome;

    private List<Reclamante> reclamantes;

    public EstadoCivilDto(EstadoCivil estadoCivil){
        this.id = estadoCivil.getId();
        this.nome = estadoCivil.getNome();
        this.reclamantes = estadoCivil.getReclamantes();
    }

    public EstadoCivilDto(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }
}
