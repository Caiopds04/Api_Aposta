package com.codex.aposta.model.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;


@Getter
public class ApostadorIn {

    public ApostadorIn(String string, String string2) {
    }

    @NotBlank
    private String nome;

    @NotBlank
    private String email;


}
