package com.tauan.api_escola.rest.controllers;

import com.tauan.api_escola.rest.dtos.AlunoDtoRequest;
import com.tauan.api_escola.rest.dtos.AlunoDtoResponse;
import com.tauan.api_escola.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDtoResponse> cadastrarAluno(@RequestBody AlunoDtoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.criarAluno(request));
    }
    @GetMapping("/{idAluno}")
    public ResponseEntity<AlunoDtoResponse> encontrarAluno(@PathVariable("idAluno")Long idAluno){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.buscarAluno(idAluno));
    }
    @PutMapping("/{idAluno}")
    public ResponseEntity<AlunoDtoResponse> atualizarAluno(@PathVariable("idAluno")Long idAluno, @RequestBody AlunoDtoRequest alunoDtoRequest){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.atualizarAluno(idAluno, alunoDtoRequest));
    }
    @DeleteMapping("/{idAluno}")
    public ResponseEntity<String> deletarAluno(@PathVariable("idAluno")Long idAluno){
        alunoService.deletarAluno(idAluno);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno de ID: " + idAluno + " deletado com sucesso.");
    }
}
