package br.vinicius.projects.controleDeProcessos.domain.dtos.anotacao;

import br.vinicius.projects.controleDeProcessos.domain.entities.Anotacao;
import br.vinicius.projects.controleDeProcessos.domain.entities.EstadoCivil;
import br.vinicius.projects.controleDeProcessos.domain.entities.Processo;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamante;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AnotacaoDto {

    private Long id;

    private Date dataAnotacao;

    private String anotacao;

    private Processo processo_id;

    public AnotacaoDto(Anotacao anotacao){
        this.id = anotacao.getId();
        this.dataAnotacao = anotacao.getDataAnotacao();
        this.anotacao = anotacao.getAnotacao();
        this.processo_id = anotacao.getProcesso_id();
    }

    public AnotacaoDto(Long id, String anotacao){
        this.id = id;
        this.anotacao = anotacao;
    }
}
