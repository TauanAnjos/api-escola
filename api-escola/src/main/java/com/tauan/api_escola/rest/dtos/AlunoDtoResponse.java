package com.tauan.api_escola.rest.dtos;

import java.time.LocalDateTime;

public record AlunoDtoResponse(
        Long id,
        String nome,
        String sexo,
        LocalDateTime dt_nascimento
) {
}
