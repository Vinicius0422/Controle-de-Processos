package br.vinicius.projects.controleDeProcessos.domain.dtos.reclamante;

import br.vinicius.projects.controleDeProcessos.domain.entities.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReclamanteDto {

    private Long id;

    private String nome;

    private Date dataNascimento;

    private String profissao;

    private String ctps;

    private String serieCtps;

    private String rg;

    private String orgaoRg;

    private String cpf;

    private String pis;

    private String endereco;

    private String cidade;

    private String bairro;

    private String uf;

    private String cep;

    private String banco;

    private String agencia;

    private String operacao;

    private String conta;

    private String contato;

    private String email;

    private Nacionalidade nacionalidade_id;

    private EstadoCivil estadoCivil_id;

    private TipoConta tipoConta_id;

    private List<Processo> processos;

    public ReclamanteDto(Reclamante reclamante){
        this.id = reclamante.getId();
        this.nome = reclamante.getNome();
        this.dataNascimento = reclamante.getDataNascimento();
        this.profissao = reclamante.getProfissao();
        this.ctps = reclamante.getCtps();
        this.serieCtps = reclamante.getSerieCtps();
        this.rg = reclamante.getRg();
        this.orgaoRg = reclamante.getOrgaoRg();
        this.cpf = reclamante.getCpf();
        this.pis = reclamante.getPis();
        this.endereco = reclamante.getEndereco();
        this.cidade = reclamante.getCidade();
        this.bairro = reclamante.getBairro();
        this.uf = reclamante.getUf();
        this.cep = reclamante.getCep();
        this.banco = reclamante.getBanco();
        this.agencia = reclamante.getAgencia();
        this.operacao = reclamante.getOperacao();
        this.conta = reclamante.getConta();
        this.contato = reclamante.getContato();
        this.email = reclamante.getEmail();
        this.nacionalidade_id = reclamante.getNacionalidade_id();
        this.estadoCivil_id = reclamante.getEstadoCivil_id();
        this.tipoConta_id = reclamante.getTipoConta_id();
        this.processos = reclamante.getProcessos();
    }

    public ReclamanteDto(Long id, String nome, Date dataNascimento, String profissao, String ctps, String serieCtps, String rg, String orgaoRg,
                         String cpf, String pis, String endereco, String cidade, String bairro, String uf, String cep, String banco, String agencia,
                         String operacao, String conta, String contato, String email, Nacionalidade nacionalidade_id, EstadoCivil estadoCivil_id,
                         TipoConta tipoConta_id) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
        this.ctps = ctps;
        this.serieCtps = serieCtps;
        this.rg = rg;
        this.orgaoRg = orgaoRg;
        this.cpf = cpf;
        this.pis = pis;
        this.endereco = endereco;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
        this.cep = cep;
        this.banco = banco;
        this.agencia = agencia;
        this.operacao = operacao;
        this.conta = conta;
        this.contato = contato;
        this.email = email;
        this.nacionalidade_id = nacionalidade_id;
        this.estadoCivil_id = estadoCivil_id;
        this.tipoConta_id = tipoConta_id;
    }
}
