package br.vinicius.projects.controleDeProcessos.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "fase_processual")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FaseProcessual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "faseProcessual_id")
    private List<Andamento> andamentos;

    @OneToMany(mappedBy = "faseProcessual_id")
    private List<Processo> processos;
}
