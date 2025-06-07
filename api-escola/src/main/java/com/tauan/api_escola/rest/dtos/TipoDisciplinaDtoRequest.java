package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.TipoDisciplinaModel;

public record TipoDisciplinaDtoRequest(
        String descricao
) {
    public TipoDisciplinaModel toModel() {
        return new TipoDisciplinaModel(null, this.descricao);
    }
}
