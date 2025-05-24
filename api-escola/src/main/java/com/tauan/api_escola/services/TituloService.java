package com.tauan.api_escola.services;

import com.tauan.api_escola.models.TituloModel;
import com.tauan.api_escola.repositories.TituloRepository;
import com.tauan.api_escola.rest.dtos.TituloDtoRequest;
import com.tauan.api_escola.rest.dtos.TituloDtoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TituloService {
    @Autowired
    private TituloRepository tituloRepository;

    public TituloDtoResponse criarTitulo(TituloDtoRequest tituloDtoRequest) {
        if (tituloDtoRequest == null) {
            throw new RuntimeException("Dados do título são obrigatórios.");
        }
        TituloModel tituloSalvo = tituloRepository.save(tituloDtoRequest.toModel());
        return tituloSalvo.toDtoResponse();
    }

    public TituloDtoResponse buscarTitulo(Long idTitulo) {
        TituloModel tituloExistente = tituloRepository.findById(idTitulo)
                .orElseThrow(() -> new RuntimeException("Título de ID: " + idTitulo + " não encontrado."));
        return tituloExistente.toDtoResponse();
    }

    public TituloDtoResponse atualizarTitulo(Long idTitulo, TituloDtoRequest tituloDtoRequest) {
        TituloModel tituloExistente = tituloRepository.findById(idTitulo)
                .orElseThrow(() -> new RuntimeException("Título de ID: " + idTitulo + " não encontrado."));

        BeanUtils.copyProperties(tituloDtoRequest, tituloExistente, "id");
        TituloModel tituloAtualizado = tituloRepository.save(tituloExistente);
        return tituloAtualizado.toDtoResponse();
    }

    public void deletarTitulo(Long idTitulo) {
        TituloModel tituloExistente = tituloRepository.findById(idTitulo)
                .orElseThrow(() -> new RuntimeException("Título de ID: " + idTitulo + " não encontrado."));
        tituloRepository.deleteById(idTitulo);
    }
}
