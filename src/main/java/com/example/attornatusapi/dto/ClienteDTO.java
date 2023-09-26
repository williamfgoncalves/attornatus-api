package com.example.attornatusapi.dto;

import java.time.LocalDate;

public record ClienteDTO(String nome, LocalDate dataNascimento){
    public ClienteDTO() {
        this(null, null);
    }
}
