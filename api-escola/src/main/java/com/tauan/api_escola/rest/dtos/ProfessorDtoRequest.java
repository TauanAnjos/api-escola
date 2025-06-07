package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.ProfessorModel;
import com.tauan.api_escola.models.TituloModel;

import java.time.LocalDateTime;

public record ProfessorDtoRequest(
        Long titulo,
        String nome,
        String sexo,
        String estado_civil,
        LocalDateTime dt_nascimento,
        String telefone
) {
    public ProfessorModel toModel(TituloModel tituloModel){
        return new ProfessorModel(null,tituloModel,this.nome,this.sexo,this.estado_civil,this.dt_nascimento,this.telefone);
    }
}
