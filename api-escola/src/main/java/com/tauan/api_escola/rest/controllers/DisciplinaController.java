package com.tauan.api_escola.rest.controllers;

import com.tauan.api_escola.rest.dtos.DisciplinaDtoRequest;
import com.tauan.api_escola.rest.dtos.DisciplinaDtoResponse;
import com.tauan.api_escola.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<DisciplinaDtoResponse> cadastrarDisciplina(@RequestBody DisciplinaDtoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.criarDisciplina(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDtoResponse> encontrarDisciplina(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.buscarDisciplina(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaDtoResponse> atualizarDisciplina(@PathVariable("id") Long id, @RequestBody DisciplinaDtoRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.atualizarDisciplina(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarDisciplina(@PathVariable("id") Long id){
        disciplinaService.deletarDisciplina(id);
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina de ID: " + id + " deletada com sucesso.");
    }
}
