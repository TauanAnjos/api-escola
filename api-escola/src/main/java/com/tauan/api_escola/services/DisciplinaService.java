package com.tauan.api_escola.services;

import com.tauan.api_escola.models.CursoModel;
import com.tauan.api_escola.models.DisciplinaModel;
import com.tauan.api_escola.models.TipoDisciplinaModel;
import com.tauan.api_escola.repositories.CursoRepository;
import com.tauan.api_escola.repositories.DisciplinaRepository;
import com.tauan.api_escola.repositories.TipoDisciplinaRepository;
import com.tauan.api_escola.rest.dtos.DisciplinaDtoRequest;
import com.tauan.api_escola.rest.dtos.DisciplinaDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TipoDisciplinaRepository tipoDisciplinaRepository;

    public DisciplinaDtoResponse criarDisciplina(DisciplinaDtoRequest dtoRequest){
        if(dtoRequest == null){
            throw new RuntimeException("Dados da disciplina são obrigatórios.");
        }

        CursoModel curso = cursoRepository.findById(dtoRequest.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso de ID: " + dtoRequest.cursoId() + " não encontrado."));

        TipoDisciplinaModel tipoDisciplina = tipoDisciplinaRepository.findById(dtoRequest.tipoDisciplinaId())
                .orElseThrow(() -> new RuntimeException("Tipo de Disciplina de ID: " + dtoRequest.tipoDisciplinaId() + " não encontrado."));

        DisciplinaModel disciplinaSalva = disciplinaRepository.save(dtoRequest.toModel(curso, tipoDisciplina));
        return disciplinaSalva.toDtoResponse();
    }

    public DisciplinaDtoResponse buscarDisciplina(Long id){
        DisciplinaModel disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina de ID: " + id + " não encontrada."));
        return disciplina.toDtoResponse();
    }

    public DisciplinaDtoResponse atualizarDisciplina(Long id, DisciplinaDtoRequest dtoRequest){
        DisciplinaModel disciplinaExistente = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina de ID: " + id + " não encontrada."));

        CursoModel curso = cursoRepository.findById(dtoRequest.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso de ID: " + dtoRequest.cursoId() + " não encontrado."));

        TipoDisciplinaModel tipoDisciplina = tipoDisciplinaRepository.findById(dtoRequest.tipoDisciplinaId())
                .orElseThrow(() -> new RuntimeException("Tipo de Disciplina de ID: " + dtoRequest.tipoDisciplinaId() + " não encontrado."));

        DisciplinaModel novaDisciplina = dtoRequest.toModel(curso, tipoDisciplina);
        novaDisciplina.setId(id); // importante manter o mesmo ID na atualização

        DisciplinaModel atualizada = disciplinaRepository.save(novaDisciplina);
        return atualizada.toDtoResponse();
    }

    public void deletarDisciplina(Long id){
        DisciplinaModel disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina de ID: " + id + " não encontrada."));
        disciplinaRepository.deleteById(id);
    }
}
