package br.vinicius.projects.controleDeProcessos.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "reclamado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Reclamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(name = "tipo_pessoa")
    private Enum tipoPessoa;

    @Column(length = 18, nullable = false, unique = true)
    private String cpf_cnpj;

    private String endereco;

    @Column(length = 50)
    private String cidade;

    @Column(length = 50)
    private String bairro;

    @Column(length = 2)
    private String uf;

    @Column(length = 10)
    private String cep;

    private String contato;

    @Column(length = 150)
    private String email;

    @ManyToMany
    @JoinTable(name = "reclamado_processo",
            joinColumns = @JoinColumn(name = "reclamado_id"),
            inverseJoinColumns = @JoinColumn(name = "processo_id"))
    private List<Processo> processos;
}
