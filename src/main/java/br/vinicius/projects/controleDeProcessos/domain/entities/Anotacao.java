package br.vinicius.projects.controleDeProcessos.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "anotacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Anotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_anotacao", nullable = false)
    private Date dataAnotacao;

    @Column(name = "note", nullable = false)
    private String anotacao;

    @ManyToOne
    @JoinColumn(name = "processo_id")
    private Processo processo_id;
}
