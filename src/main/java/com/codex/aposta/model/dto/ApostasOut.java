package com.codex.aposta.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApostasOut {

    public ApostasOut(String string, String string2, String string3) {
    }

    private String numeroAposta;

    private Long idApostador;
}
