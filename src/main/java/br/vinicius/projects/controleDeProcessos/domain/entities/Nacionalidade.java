package br.vinicius.projects.controleDeProcessos.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nacionalidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Nacionalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String nome;
}
