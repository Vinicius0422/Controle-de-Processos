package br.vinicius.projects.controleDeProcessos.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDefault {

    private int statusCode;

    private List<String> mensagens;

}
