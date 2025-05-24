package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.InstituicaoModel;

public record InstituicaoDtoRequest(
        String sigla,
        String descricao
) {
    public InstituicaoModel toModel() {
        return new InstituicaoModel(null,this.sigla,this.descricao);
    }
}
