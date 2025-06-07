package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.CursaModel;

import java.math.BigDecimal;

public record CursaDtoResponse(
        CursaModel.CursaId id,
        Integer ano,
        Integer semestre,
        Integer faltas,
        BigDecimal nota1,
        BigDecimal nota2,
        BigDecimal nota3,
        boolean aprovado
) {
}
