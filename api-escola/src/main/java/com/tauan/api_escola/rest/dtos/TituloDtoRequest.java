package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.TituloModel;

public record TituloDtoRequest(
        String descricao
) {
    public TituloModel toModel() {
        return new TituloModel(null,this.descricao);
    }
}
