package com.tauan.api_escola.rest.controllers;

import com.tauan.api_escola.rest.dtos.ProfessorDtoRequest;
import com.tauan.api_escola.rest.dtos.ProfessorDtoResponse;
import com.tauan.api_escola.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDtoResponse> cadastrarProfessor(@RequestBody ProfessorDtoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.criarProfessor(request));
    }
    @GetMapping("/{idProfessor}")
    public ResponseEntity<ProfessorDtoResponse> encontrarProfessor(@PathVariable("idProfessor") Long idProfessor) {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.buscarProfessor(idProfessor));
    }
    @PutMapping("/{idProfessor}")
    public ResponseEntity<ProfessorDtoResponse> atualizarProfessor(@PathVariable("idProfessor") Long idProfessor, @RequestBody ProfessorDtoRequest professorDtoRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.atualizarProfessor(idProfessor, professorDtoRequest));
    }
    @DeleteMapping("/{idProfessor}")
    public ResponseEntity<String> deletarProfessor(@PathVariable("idProfessor") Long idProfessor) {
        professorService.deletarProfessor(idProfessor);
        return ResponseEntity.status(HttpStatus.OK).body("Professor de ID: " + idProfessor + " deletado com sucesso.");
    }
}
