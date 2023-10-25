package br.vinicius.projects.controleDeProcessos.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "reclamante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Reclamante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(length = 50)
    private String profissao;

    @Column(length = 9, nullable = false)
    private String ctps;

    @Column(length = 9, nullable = false, name = "serie")
    private String serieCtps;

    @Column(length = 10, nullable = false, unique = true)
    private String rg;

    @Column(length = 10, nullable = false, name = "orgao_rg")
    private String orgaoRg;

    @Column(length = 14, nullable = false, unique = true)
    private String cpf;

    @Column(length = 50)
    private String pis;

    @Column(length = 255, nullable = false)
    private String endereco;

    @Column(length = 50, nullable = false)
    private String cidade;

    @Column(length = 50, nullable = false)
    private String bairro;

    @Column(length = 2, nullable = false)
    private String uf;

    @Column(length = 10, nullable = false)
    private String cep;

    @Column(length = 50)
    private String banco;

    @Column(length = 10)
    private String agencia;

    @Column(length = 10)
    private String operacao;

    @Column(length = 20)
    private String conta;

    @Column(length = 255, nullable = false)
    private String contato;

    @Column(length = 150)
    private String email;

    @ManyToOne
    @JoinColumn(name = "nacionalidade_id")
    private Nacionalidade nacionalidade_id;

    @ManyToOne
    @JoinColumn(name = "estadocivil_id")
    private EstadoCivil estadoCivil_id;

    @ManyToOne
    @JoinColumn(name = "tipoconta_id")
    private TipoConta tipoConta_id;

    @OneToMany(mappedBy = "reclamante_id")
    private List<Processo> processos;

}
