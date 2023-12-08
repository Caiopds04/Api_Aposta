package com.codex.aposta.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ApostaOut {


    private String  numeroAposta;
    private String  nomeApostador;
    private String  emailApostador;
}
