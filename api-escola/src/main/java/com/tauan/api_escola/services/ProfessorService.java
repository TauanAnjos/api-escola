package com.tauan.api_escola.services;

import com.tauan.api_escola.models.ProfessorModel;
import com.tauan.api_escola.repositories.ProfessorRepository;
import com.tauan.api_escola.rest.dtos.ProfessorDtoRequest;
import com.tauan.api_escola.rest.dtos.ProfessorDtoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorDtoResponse criarProfessor(ProfessorDtoRequest professorDtoRequest){
        if (professorDtoRequest == null){
            throw new RuntimeException("Dados do professor são obrigatorios.");
        }
        ProfessorModel professorSalvo =  professorRepository.save(professorDtoRequest.toModel());
        return professorSalvo.toDtoResponse();
    }
    public ProfessorDtoResponse buscarProfessor(Long idProfessor) {
        ProfessorModel professorExistente = professorRepository.findById(idProfessor)
                .orElseThrow(() -> new RuntimeException("Professor de ID: " + idProfessor + " não encontrado."));
        return professorExistente.toDtoResponse();
    }
    public ProfessorDtoResponse atualizarProfessor(Long idProfessor, ProfessorDtoRequest professorDtoRequest) {
        ProfessorModel professorExistente = professorRepository.findById(idProfessor)
                .orElseThrow(() -> new RuntimeException("Professor de ID: " + idProfessor + " não encontrado."));

        BeanUtils.copyProperties(professorDtoRequest, professorExistente, "id");

        ProfessorModel professorAtualizado = professorRepository.save(professorExistente);
        return professorAtualizado.toDtoResponse();
    }
    public void deletarProfessor(Long idProfessor) {
        ProfessorModel professorExistente = professorRepository.findById(idProfessor)
                .orElseThrow(() -> new RuntimeException("Professor de ID: " + idProfessor + " não encontrado."));
        professorRepository.deleteById(idProfessor);
    }
}
