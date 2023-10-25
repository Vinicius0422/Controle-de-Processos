package br.vinicius.projects.controleDeProcessos.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "processo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false, unique = true, name = "numero_processo")
    private String numeroProcesso;

    @Column(length = 5, nullable = false)
    private String vara;

    @Column(nullable = false, name = "data_distribuicao")
    private Date dataDistribuicao;

    @Column(length = 10, name = "valor_causa")
    private Double valorCausa;

    @ManyToOne
    @JoinColumn(name = "faseprocessual_id")
    private FaseProcessual faseProcessual_id;

    @ManyToOne
    @JoinColumn(name = "resultado_id")
    private Resultado resultado_id;

    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    private Localizacao localizacao_id;

    @ManyToOne
    @JoinColumn(name = "reclamante_id")
    private Reclamante reclamante_id;

    @OneToMany(mappedBy = "processo_id")
    private List<Andamento> andamentos;

    @OneToMany(mappedBy = "processo_id")
    private List<Anotacao> anotacoes;

    @ManyToMany(mappedBy = "processos")
    private List<Reclamado> reclamados;

    @ManyToMany(mappedBy = "processos")
    private List<Advogado> advogados;


}
