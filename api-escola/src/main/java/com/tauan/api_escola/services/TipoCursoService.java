package com.tauan.api_escola.services;

import com.tauan.api_escola.models.TipoCursoModel;
import com.tauan.api_escola.repositories.TipoCursoRepository;
import com.tauan.api_escola.rest.dtos.TipoCursoDtoRequest;
import com.tauan.api_escola.rest.dtos.TipoCursoDtoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoCursoService {
    @Autowired
    private TipoCursoRepository tipoCursoRepository;

    public TipoCursoDtoResponse criarTipoCurso(TipoCursoDtoRequest tipoCursoDtoRequest){
        if (tipoCursoDtoRequest == null) {
            throw new RuntimeException("Dados do tipo de curso são obrigatórios");
        }

        TipoCursoModel tipoCursoSalvo = tipoCursoRepository.save(tipoCursoDtoRequest.toModel());
        return tipoCursoSalvo.toDtoResponse();
    }

    public TipoCursoDtoResponse buscarTipoCurso(Long idTipoCurso) {
        TipoCursoModel tipoCursoExistente = tipoCursoRepository.findById(idTipoCurso)
                .orElseThrow(() -> new RuntimeException("Tipo de curso com ID: " + idTipoCurso + " não encontrado."));
        return tipoCursoExistente.toDtoResponse();
    }

    public TipoCursoDtoResponse atualizarTipoCurso(Long idTipoCurso, TipoCursoDtoRequest tipoCursoDtoRequest) {
        TipoCursoModel tipoCursoExistente = tipoCursoRepository.findById(idTipoCurso)
                .orElseThrow(() -> new RuntimeException("Tipo de curso com ID: " + idTipoCurso + " não encontrado."));

        BeanUtils.copyProperties(tipoCursoDtoRequest, tipoCursoExistente, "id");
        TipoCursoModel tipoCursoAtualizado = tipoCursoRepository.save(tipoCursoExistente);
        return tipoCursoAtualizado.toDtoResponse();
    }

    public void deletarTipoCurso(Long idTipoCurso) {
        TipoCursoModel tipoCursoExistente = tipoCursoRepository.findById(idTipoCurso)
                .orElseThrow(() -> new RuntimeException("Tipo de curso com ID: " + idTipoCurso + " não encontrado."));
        tipoCursoRepository.deleteById(idTipoCurso);
    }
}
