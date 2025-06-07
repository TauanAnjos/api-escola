package com.tauan.api_escola.services;

import com.tauan.api_escola.models.LecionaModel;
import com.tauan.api_escola.models.LecionaModel.LecionaId;
import com.tauan.api_escola.repositories.LecionaRepository;
import com.tauan.api_escola.rest.dtos.LecionaDtoRequest;
import com.tauan.api_escola.rest.dtos.LecionaDtoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecionaService {

    @Autowired
    private LecionaRepository lecionaRepository;

    public LecionaDtoResponse criarLeciona(LecionaDtoRequest lecionaDtoRequest) {
        if (lecionaDtoRequest == null) {
            throw new RuntimeException("Dados do leciona são obrigatórios");
        }
        LecionaModel lecionaSalvo = lecionaRepository.save(lecionaDtoRequest.toModel());
        return lecionaSalvo.toDtoResponse();
    }

    public LecionaDtoResponse buscarLeciona(LecionaId idLeciona) {
        LecionaModel lecionaExistente = lecionaRepository.findById(idLeciona)
                .orElseThrow(() -> new RuntimeException("Registro de Leciona com ID composto não encontrado."));
        return lecionaExistente.toDtoResponse();
    }

    public LecionaDtoResponse atualizarLeciona(LecionaId idLeciona, LecionaDtoRequest lecionaDtoRequest) {
        LecionaModel lecionaExistente = lecionaRepository.findById(idLeciona)
                .orElseThrow(() -> new RuntimeException("Registro de Leciona com ID composto não encontrado."));

        // Copia as propriedades do DTO para o model, exceto o id (que é embutido)
        BeanUtils.copyProperties(lecionaDtoRequest, lecionaExistente, "id");
        LecionaModel lecionaAtualizado = lecionaRepository.save(lecionaExistente);
        return lecionaAtualizado.toDtoResponse();
    }

    public void deletarLeciona(LecionaId idLeciona) {
        LecionaModel lecionaExistente = lecionaRepository.findById(idLeciona)
                .orElseThrow(() -> new RuntimeException("Registro de Leciona com ID composto não encontrado."));
        lecionaRepository.deleteById(idLeciona);
    }
}
