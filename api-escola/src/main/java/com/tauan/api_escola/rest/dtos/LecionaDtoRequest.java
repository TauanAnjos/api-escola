package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.LecionaModel;
import com.tauan.api_escola.models.LecionaModel.LecionaId;

public record LecionaDtoRequest(Integer idProfessor, Integer idDisciplina) {

    public LecionaModel toModel() {
        LecionaId id = new LecionaId();
        id.setIdProfessor(this.idProfessor);
        id.setIdDisciplina(this.idDisciplina);

        LecionaModel model = new LecionaModel();
        model.setId(id);
        return model;
    }
}
