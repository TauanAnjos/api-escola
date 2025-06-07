package com.tauan.api_escola.services;

import com.tauan.api_escola.models.CursaModel;
import com.tauan.api_escola.models.CursaModel.CursaId;
import com.tauan.api_escola.repositories.CursaRepository;
import com.tauan.api_escola.rest.dtos.CursaDtoRequest;
import com.tauan.api_escola.rest.dtos.CursaDtoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursaService {

    @Autowired
    private CursaRepository cursaRepository;

    public CursaDtoResponse criarCursa(CursaDtoRequest cursaDtoRequest) {
        if (cursaDtoRequest == null) {
            throw new RuntimeException("Dados do cursa são obrigatórios");
        }
        CursaModel cursaSalvo = cursaRepository.save(cursaDtoRequest.toModel());
        return cursaSalvo.toDtoResponse();
    }

    public CursaDtoResponse buscarCursa(CursaId idCursa) {
        CursaModel cursaExistente = cursaRepository.findById(idCursa)
                .orElseThrow(() -> new RuntimeException("Registro de Cursa com ID composto não encontrado."));
        return cursaExistente.toDtoResponse();
    }

    public CursaDtoResponse atualizarCursa(CursaId idCursa, CursaDtoRequest cursaDtoRequest) {
        CursaModel cursaExistente = cursaRepository.findById(idCursa)
                .orElseThrow(() -> new RuntimeException("Registro de Cursa com ID composto não encontrado."));

        BeanUtils.copyProperties(cursaDtoRequest, cursaExistente, "id");
        CursaModel cursaAtualizado = cursaRepository.save(cursaExistente);
        return cursaAtualizado.toDtoResponse();
    }

    public void deletarCursa(CursaId idCursa) {
        CursaModel cursaExistente = cursaRepository.findById(idCursa)
                .orElseThrow(() -> new RuntimeException("Registro de Cursa com ID composto não encontrado."));
        cursaRepository.deleteById(idCursa);
    }
}
