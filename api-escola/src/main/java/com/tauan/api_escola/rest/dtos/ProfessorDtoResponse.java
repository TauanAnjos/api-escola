package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.TituloModel;

import java.time.LocalDateTime;

public record ProfessorDtoResponse(
        Long id,
        TituloModel titulo,
        String nome,
        String sexo,
        String estado_civil,
        LocalDateTime dt_nascimento,
        String telefone
) {
}
