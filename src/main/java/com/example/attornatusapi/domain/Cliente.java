package com.example.attornatusapi.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Cliente {

    private final String nome;
    private final LocalDate dataNascimento;
}
