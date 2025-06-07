package com.tauan.api_escola.rest.controllers;

import com.tauan.api_escola.models.LecionaModel.LecionaId;
import com.tauan.api_escola.rest.dtos.LecionaDtoRequest;
import com.tauan.api_escola.rest.dtos.LecionaDtoResponse;
import com.tauan.api_escola.services.LecionaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leciona")
public class LecionaController {

    @Autowired
    private LecionaService lecionaService;

    @PostMapping
    public ResponseEntity<LecionaDtoResponse> cadastrarLeciona(@RequestBody LecionaDtoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lecionaService.criarLeciona(request));
    }

    @GetMapping("/{idProfessor}/{idDisciplina}")
    public ResponseEntity<LecionaDtoResponse> encontrarLeciona(
            @PathVariable("idProfessor") Integer idProfessor,
            @PathVariable("idDisciplina") Integer idDisciplina) {

        LecionaId lecionaId = new LecionaId();
        lecionaId.setIdProfessor(idProfessor);
        lecionaId.setIdDisciplina(idDisciplina);

        return ResponseEntity.status(HttpStatus.OK).body(lecionaService.buscarLeciona(lecionaId));
    }

    @PutMapping("/{idProfessor}/{idDisciplina}")
    public ResponseEntity<LecionaDtoResponse> atualizarLeciona(
            @PathVariable("idProfessor") Integer idProfessor,
            @PathVariable("idDisciplina") Integer idDisciplina,
            @RequestBody LecionaDtoRequest lecionaDtoRequest) {

        LecionaId lecionaId = new LecionaId();
        lecionaId.setIdProfessor(idProfessor);
        lecionaId.setIdDisciplina(idDisciplina);

        return ResponseEntity.status(HttpStatus.OK).body(lecionaService.atualizarLeciona(lecionaId, lecionaDtoRequest));
    }

    @DeleteMapping("/{idProfessor}/{idDisciplina}")
    public ResponseEntity<String> deletarLeciona(
            @PathVariable("idProfessor") Integer idProfessor,
            @PathVariable("idDisciplina") Integer idDisciplina) {

        LecionaId lecionaId = new LecionaId();
        lecionaId.setIdProfessor(idProfessor);
        lecionaId.setIdDisciplina(idDisciplina);

        lecionaService.deletarLeciona(lecionaId);
        return ResponseEntity.status(HttpStatus.OK).body("Registro de Leciona deletado com sucesso.");
    }
}
