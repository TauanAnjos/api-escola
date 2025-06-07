package com.tauan.api_escola.rest.controllers;

import com.tauan.api_escola.rest.dtos.CursoDtoRequest;
import com.tauan.api_escola.rest.dtos.CursoDtoResponse;
import com.tauan.api_escola.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoDtoResponse> cadastrarCurso(@RequestBody CursoDtoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.criarCurso(request));
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<CursoDtoResponse> encontrarCurso(@PathVariable("idCurso") Long idCurso) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.buscarCurso(idCurso));
    }

    @PutMapping("/{idCurso}")
    public ResponseEntity<CursoDtoResponse> atualizarCurso(
            @PathVariable("idCurso") Long idCurso,
            @RequestBody CursoDtoRequest cursoDtoRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(cursoService.atualizarCurso(idCurso, cursoDtoRequest));
    }

    @DeleteMapping("/{idCurso}")
    public ResponseEntity<String> deletarCurso(@PathVariable("idCurso") Long idCurso) {
        cursoService.deletarCurso(idCurso);
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso.");
    }
}
