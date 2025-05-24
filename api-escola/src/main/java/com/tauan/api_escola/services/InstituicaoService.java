package com.tauan.api_escola.services;

import com.tauan.api_escola.models.InstituicaoModel;
import com.tauan.api_escola.repositories.InstituicaoRepository;
import com.tauan.api_escola.rest.dtos.InstituicaoDtoRequest;
import com.tauan.api_escola.rest.dtos.InstituicaoDtoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoService {
    @Autowired
    private InstituicaoRepository instituicaoRepository;

    public InstituicaoDtoResponse criarInstituicao(InstituicaoDtoRequest instituicaoDtoRequest){
        if (instituicaoDtoRequest == null){
            throw new RuntimeException("Dados da instituição são obrigatórios.");
        }
        InstituicaoModel instituicaoSalva = instituicaoRepository.save(instituicaoDtoRequest.toModel());
        return instituicaoSalva.toDtoResponse();
    }

    public InstituicaoDtoResponse buscarInstituicao(Long idInstituicao){
        InstituicaoModel instituicaoExistente = instituicaoRepository.findById(idInstituicao)
                .orElseThrow(() -> new RuntimeException("Instituição de ID: " + idInstituicao + " não encontrada."));
        return instituicaoExistente.toDtoResponse();
    }

    public InstituicaoDtoResponse atualizarInstituicao(Long idInstituicao, InstituicaoDtoRequest instituicaoDtoRequest){
        InstituicaoModel instituicaoExistente = instituicaoRepository.findById(idInstituicao)
                .orElseThrow(() -> new RuntimeException("Instituição de ID: " + idInstituicao + " não encontrada."));

        BeanUtils.copyProperties(instituicaoDtoRequest, instituicaoExistente, "id");
        InstituicaoModel instituicaoAtualizada = instituicaoRepository.save(instituicaoExistente);
        return instituicaoAtualizada.toDtoResponse();
    }

    public void deletarInstituicao(Long idInstituicao){
        InstituicaoModel instituicaoExistente = instituicaoRepository.findById(idInstituicao)
                .orElseThrow(() -> new RuntimeException("Instituição de ID: " + idInstituicao + " não encontrada."));
        instituicaoRepository.deleteById(idInstituicao);
    }
}
