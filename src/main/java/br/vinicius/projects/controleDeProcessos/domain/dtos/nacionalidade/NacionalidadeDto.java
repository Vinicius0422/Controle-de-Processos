package br.vinicius.projects.controleDeProcessos.domain.dtos.nacionalidade;

import br.vinicius.projects.controleDeProcessos.domain.dtos.reclamante.ReclamanteDto;
import br.vinicius.projects.controleDeProcessos.domain.entities.Nacionalidade;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamante;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class NacionalidadeDto {

    private Long id;

    private String nome;

    private List<Reclamante> reclamantes;

    public NacionalidadeDto(Nacionalidade nacionalidade){
        this.id = nacionalidade.getId();
        this.nome = nacionalidade.getNome();
        this.reclamantes = nacionalidade.getReclamantes();
    }

    public NacionalidadeDto(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }
}
