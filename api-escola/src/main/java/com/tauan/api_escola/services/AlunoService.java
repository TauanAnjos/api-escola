package com.tauan.api_escola.services;

import com.tauan.api_escola.models.AlunoModel;
import com.tauan.api_escola.repositories.AlunoRepository;
import com.tauan.api_escola.rest.dtos.AlunoDtoRequest;
import com.tauan.api_escola.rest.dtos.AlunoDtoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public AlunoDtoResponse buscarAluno(Long idAluno){
        AlunoModel alunoExistente = alunoRepository.findById(idAluno).orElseThrow(() -> new RuntimeException("Aluno de ID: " + idAluno + " não encontrado."));
        return alunoExistente.toDtoResponse();
    }

    public AlunoDtoResponse atualizarAluno(Long idAluno, AlunoDtoRequest alunoDtoRequest){
        AlunoModel alunoExistente = alunoRepository.findById(idAluno).orElseThrow(() -> new RuntimeException("Aluno de ID: " + idAluno + "não encontrado."));

        BeanUtils.copyProperties(alunoDtoRequest, alunoExistente, "id");
        AlunoModel alunoAtualizado = alunoRepository.save(alunoExistente);
        return alunoAtualizado.toDtoResponse();
    }

    public void deletarAluno(Long idAluno){
        AlunoModel alunoExistente = alunoRepository.findById(idAluno).orElseThrow(() -> new RuntimeException("Aluno de ID: " + idAluno + "não encontrado."));
        alunoRepository.deleteById(idAluno);
    }
}
