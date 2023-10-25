package br.vinicius.projects.controleDeProcessos.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "andamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Andamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "data_andamento")
    private Date dataAndamento;

    @Column(name = "data_prevista")
    private Date dataPrevista;

    @Column(name = "hora_prevista")
    private Time horaPrevista;

    @Column(length = 255, nullable = false)
    private String descricao;

    @Column(nullable = false, name = "data_criacao")
    private Timestamp dataCriacao;

    @ManyToOne
    @JoinColumn(name = "faseprocessual_id")
    private FaseProcessual faseProcessual_id;

    @ManyToOne
    @JoinColumn(name = "processo_id")
    private Processo processo_id;
}
