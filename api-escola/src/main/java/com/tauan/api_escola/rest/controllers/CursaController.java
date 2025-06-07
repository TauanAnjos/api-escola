package com.tauan.api_escola.rest.controllers;

import com.tauan.api_escola.models.CursaModel.CursaId;
import com.tauan.api_escola.rest.dtos.CursaDtoRequest;
import com.tauan.api_escola.rest.dtos.CursaDtoResponse;
import com.tauan.api_escola.services.CursaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursa")
public class CursaController {

    @Autowired
    private CursaService cursaService;

    @PostMapping
    public ResponseEntity<CursaDtoResponse> cadastrarCursa(@RequestBody CursaDtoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursaService.criarCursa(request));
    }

    @GetMapping("/{idAluno}/{idDisciplina}")
    public ResponseEntity<CursaDtoResponse> encontrarCursa(
            @PathVariable("idAluno") Integer idAluno,
            @PathVariable("idDisciplina") Integer idDisciplina) {

        CursaId cursaId = new CursaId();
        cursaId.setId_aluno(idAluno);
        cursaId.setId_disciplina(idDisciplina);

        return ResponseEntity.status(HttpStatus.OK).body(cursaService.buscarCursa(cursaId));
    }

    @PutMapping("/{idAluno}/{idDisciplina}")
    public ResponseEntity<CursaDtoResponse> atualizarCursa(
            @PathVariable("idAluno") Integer idAluno,
            @PathVariable("idDisciplina") Integer idDisciplina,
            @RequestBody CursaDtoRequest cursaDtoRequest) {

        CursaId cursaId = new CursaId();
        cursaId.setId_aluno(idAluno);
        cursaId.setId_disciplina(idDisciplina);

        return ResponseEntity.status(HttpStatus.OK).body(cursaService.atualizarCursa(cursaId, cursaDtoRequest));
    }

    @DeleteMapping("/{idAluno}/{idDisciplina}")
    public ResponseEntity<String> deletarCursa(
            @PathVariable("idAluno") Integer idAluno,
            @PathVariable("idDisciplina") Integer idDisciplina) {

        CursaId cursaId = new CursaId();
        cursaId.setId_aluno(idAluno);
        cursaId.setId_disciplina(idDisciplina);

        cursaService.deletarCursa(cursaId);
        return ResponseEntity.status(HttpStatus.OK).body("Registro de Cursa deletado com sucesso.");
    }
}
