package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.CursoModel;
import com.tauan.api_escola.models.DisciplinaModel;
import com.tauan.api_escola.models.TipoCursoModel;
import com.tauan.api_escola.models.TipoDisciplinaModel;

public record DisciplinaDtoRequest(
       Long cursoId,
       Long tipoDisciplinaId,
       String sigla,
       String descricao,
       Integer periodo,
       Integer carga_horaria
) {
    public DisciplinaModel toModel(CursoModel cursoModel, TipoDisciplinaModel disciplinaModel) {
        return new DisciplinaModel(null,cursoModel,disciplinaModel,this.sigla,this.descricao,this.periodo,this.carga_horaria);
    }
}
