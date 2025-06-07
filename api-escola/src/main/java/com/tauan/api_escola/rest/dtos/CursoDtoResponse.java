package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.InstituicaoModel;
import com.tauan.api_escola.models.TipoCursoModel;

public record CursoDtoResponse(
        Long id,
        InstituicaoModel instituicao,
        TipoCursoModel tipoCurso,
        String descricao
) {
}
