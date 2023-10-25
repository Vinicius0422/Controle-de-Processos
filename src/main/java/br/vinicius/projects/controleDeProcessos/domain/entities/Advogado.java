package br.vinicius.projects.controleDeProcessos.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "advogado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Advogado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 14, nullable = false, unique = true)
    private String cpf;

    @Column(length = 20, nullable = false, unique = true, name = "numero_oab")
    private String numeroOab;

    @ManyToMany
    @JoinTable(name = "advogado_processo",
            joinColumns = @JoinColumn(name = "advogado_id"),
            inverseJoinColumns = @JoinColumn(name = "processo_id"))
    private List<Processo> processos;
}
