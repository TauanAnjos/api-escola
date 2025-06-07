package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.CursoModel;
import com.tauan.api_escola.models.TipoDisciplinaModel;

public record DisciplinaDtoResponse(
        Long id,
        CursoModel curso,
        TipoDisciplinaModel tipoDisciplina,
        String sigla,
        String descricao,
        Integer periodo,
        Integer carga_horaria
) {
}
