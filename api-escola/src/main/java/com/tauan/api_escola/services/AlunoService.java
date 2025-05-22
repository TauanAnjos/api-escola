package com.tauan.api_escola.services;

import com.tauan.api_escola.models.AlunoModel;
import com.tauan.api_escola.repositories.AlunoRepository;
import com.tauan.api_escola.rest.dtos.AlunoDtoRequest;
import com.tauan.api_escola.rest.dtos.AlunoDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoDtoResponse criarAluno(AlunoDtoRequest alunoDtoRequest){
        if(alunoDtoRequest == null){
            throw new RuntimeException("Dados do aluno são obrigatorios");
        }
        AlunoModel alunoSalvo = alunoRepository.save(alunoDtoRequest.toModel());
        return alunoSalvo.toDtoResponse();
    }
}
