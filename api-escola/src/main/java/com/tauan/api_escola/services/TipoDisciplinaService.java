package com.tauan.api_escola.services;

import com.tauan.api_escola.models.TipoDisciplinaModel;
import com.tauan.api_escola.repositories.TipoDisciplinaRepository;
import com.tauan.api_escola.rest.dtos.TipoDisciplinaDtoRequest;
import com.tauan.api_escola.rest.dtos.TipoDisciplinaDtoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDisciplinaService {
    @Autowired
    private TipoDisciplinaRepository tipoDisciplinaRepository;

    public TipoDisciplinaDtoResponse criarTipoDisciplina(TipoDisciplinaDtoRequest tipoDisciplinaDtoRequest){
        if (tipoDisciplinaDtoRequest == null) {
            throw new RuntimeException("Dados do tipo de disciplina são obrigatórios");
        }

        TipoDisciplinaModel tipoDisciplinaSalvo = tipoDisciplinaRepository.save(tipoDisciplinaDtoRequest.toModel());
        return tipoDisciplinaSalvo.toDtoResponse();
    }

    public TipoDisciplinaDtoResponse buscarTipoDisciplina(Long idTipoDisciplina) {
        TipoDisciplinaModel tipoDisciplinaExistente = tipoDisciplinaRepository.findById(idTipoDisciplina)
                .orElseThrow(() -> new RuntimeException("Tipo de disciplina com ID: " + idTipoDisciplina + " não encontrado."));
        return tipoDisciplinaExistente.toDtoResponse();
    }

    public TipoDisciplinaDtoResponse atualizarTipoDisciplina(Long idTipoDisciplina, TipoDisciplinaDtoRequest tipoDisciplinaDtoRequest) {
        TipoDisciplinaModel tipoDisciplinaExistente = tipoDisciplinaRepository.findById(idTipoDisciplina)
                .orElseThrow(() -> new RuntimeException("Tipo de disciplina com ID: " + idTipoDisciplina + " não encontrado."));

        BeanUtils.copyProperties(tipoDisciplinaDtoRequest, tipoDisciplinaExistente, "id");
        TipoDisciplinaModel tipoDisciplinaAtualizado = tipoDisciplinaRepository.save(tipoDisciplinaExistente);
        return tipoDisciplinaAtualizado.toDtoResponse();
    }

    public void deletarTipoDisciplina(Long idTipoDisciplina) {
        TipoDisciplinaModel tipoDisciplinaExistente = tipoDisciplinaRepository.findById(idTipoDisciplina)
                .orElseThrow(() -> new RuntimeException("Tipo de disciplina com ID: " + idTipoDisciplina + " não encontrado."));
        tipoDisciplinaRepository.deleteById(idTipoDisciplina);
    }
}
