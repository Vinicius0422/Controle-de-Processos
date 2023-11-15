package br.vinicius.projects.controleDeProcessos.domain.dtos.reclamado;

import br.vinicius.projects.controleDeProcessos.domain.entities.Processo;
import br.vinicius.projects.controleDeProcessos.domain.entities.Reclamado;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReclamadoDto {

    private Long id;
    private String nome;
    private Enum tipoPessoa;
    private String cpf_cnpj;
    private String endereco;
    private String cidade;
    private String bairro;
    private String uf;
    private String cep;
    private String contato;
    private String email;
    private List<Processo> processos;

    public ReclamadoDto(Reclamado reclamado){
        this.id = reclamado.getId();
        this.nome = reclamado.getNome();
        this.tipoPessoa = reclamado.getTipoPessoa();
        this.cpf_cnpj = reclamado.getCpfCnpj();
        this.endereco = reclamado.getEndereco();
        this.cidade = reclamado.getCidade();
        this.bairro = reclamado.getBairro();
        this.uf = reclamado.getUf();
        this.cep = reclamado.getCep();
        this.contato = reclamado.getContato();
        this.email = reclamado.getEmail();
        this.processos = reclamado.getProcessos();
    }
}
