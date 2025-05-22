package com.tauan.api_escola.rest.controllers;

import com.tauan.api_escola.rest.dtos.AlunoDtoRequest;
import com.tauan.api_escola.rest.dtos.AlunoDtoResponse;
import com.tauan.api_escola.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDtoResponse> cadastrarAluno(@RequestBody AlunoDtoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.criarAluno(request));
    }
}
