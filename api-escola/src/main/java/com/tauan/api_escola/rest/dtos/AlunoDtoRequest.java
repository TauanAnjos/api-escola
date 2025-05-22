package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.AlunoModel;

import java.time.LocalDateTime;

public record AlunoDtoRequest(
        String nome,
        String sexo,
        LocalDateTime dt_nascimento

) {
    public AlunoModel toModel() {
        return new AlunoModel(null,this.nome, this.sexo, this.dt_nascimento);
    }
}
