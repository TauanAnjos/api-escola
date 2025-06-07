package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.CursoModel;
import com.tauan.api_escola.models.InstituicaoModel;
import com.tauan.api_escola.models.TipoCursoModel;

public record CursoDtoRequest(

        Long instituicaoId,
        Long tipoCursoId,
        String descricao
) {
    public CursoModel toModel(InstituicaoModel instituicaoModel, TipoCursoModel tipoCursoModel) {
        return new CursoModel(null,instituicaoModel, tipoCursoModel, descricao);
    }
}
