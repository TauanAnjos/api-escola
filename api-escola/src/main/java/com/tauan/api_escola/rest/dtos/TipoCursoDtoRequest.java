package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.TipoCursoModel;

public record TipoCursoDtoRequest(
        String descricao
) {
    public TipoCursoModel toModel() {
        return new TipoCursoModel(null, this.descricao);
    }
}
