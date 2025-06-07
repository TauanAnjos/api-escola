package com.tauan.api_escola.services;

import com.tauan.api_escola.models.CursoModel;
import com.tauan.api_escola.models.InstituicaoModel;
import com.tauan.api_escola.models.TipoCursoModel;
import com.tauan.api_escola.repositories.CursoRepository;
import com.tauan.api_escola.repositories.InstituicaoRepository;
import com.tauan.api_escola.repositories.TipoCursoRepository;
import com.tauan.api_escola.rest.dtos.CursoDtoRequest;
import com.tauan.api_escola.rest.dtos.CursoDtoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private TipoCursoRepository tipoCursoRepository;

    public CursoDtoResponse criarCurso(CursoDtoRequest cursoDtoRequest) {
        if (cursoDtoRequest == null) {
            throw new RuntimeException("Dados do curso são obrigatórios.");
        }

        InstituicaoModel instituicaoModel = instituicaoRepository.findById(cursoDtoRequest.instituicaoId())
                .orElseThrow(() -> new RuntimeException("Instituição com ID " + cursoDtoRequest.instituicaoId() + " não encontrada."));

        TipoCursoModel tipoCursoModel = tipoCursoRepository.findById(cursoDtoRequest.tipoCursoId())
                .orElseThrow(() -> new RuntimeException("Tipo de curso com ID " + cursoDtoRequest.tipoCursoId() + " não encontrado."));

        CursoModel cursoSalvo = cursoRepository.save(cursoDtoRequest.toModel(instituicaoModel, tipoCursoModel));
        return cursoSalvo.toDtoResponse();
    }

    public CursoDtoResponse buscarCurso(Long idCurso) {
        CursoModel curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Curso com ID " + idCurso + " não encontrado."));
        return curso.toDtoResponse();
    }

    public CursoDtoResponse atualizarCurso(Long idCurso, CursoDtoRequest cursoDtoRequest) {
        CursoModel cursoExistente = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Curso com ID " + idCurso + " não encontrado."));

        InstituicaoModel instituicaoModel = instituicaoRepository.findById(cursoDtoRequest.instituicaoId())
                .orElseThrow(() -> new RuntimeException("Instituição com ID " + cursoDtoRequest.instituicaoId() + " não encontrada."));

        TipoCursoModel tipoCursoModel = tipoCursoRepository.findById(cursoDtoRequest.tipoCursoId())
                .orElseThrow(() -> new RuntimeException("Tipo de curso com ID " + cursoDtoRequest.tipoCursoId() + " não encontrado."));

        // Atualiza os dados do curso
        cursoExistente.setDescricao(cursoDtoRequest.descricao());
        cursoExistente.setInstituicao(instituicaoModel);
        cursoExistente.setTipoCurso(tipoCursoModel);

        CursoModel cursoAtualizado = cursoRepository.save(cursoExistente);
        return cursoAtualizado.toDtoResponse();
    }

    public void deletarCurso(Long idCurso) {
        CursoModel cursoExistente = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Curso com ID " + idCurso + " não encontrado."));
        cursoRepository.deleteById(idCurso);
    }
}
