package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.CursaModel;

import java.math.BigDecimal;

public record CursaDtoRequest(
        Integer idAluno,
        Integer idDisciplina,
        Integer ano,
        Integer semestre,
        Integer faltas,
        BigDecimal nota1,
        BigDecimal nota2,
        BigDecimal nota3,
        boolean aprovado
) {
    public CursaModel toModel(){
        CursaModel.CursaId id = new CursaModel.CursaId();
        id.setId_aluno(idAluno);
        id.setId_disciplina(idDisciplina);
        return new CursaModel(id, this.ano, this.semestre, this.faltas, this.nota1, this.nota2, this.nota3, this.aprovado);
    }
}

