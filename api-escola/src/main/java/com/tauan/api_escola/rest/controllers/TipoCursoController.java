package com.tauan.api_escola.rest.controllers;

import com.tauan.api_escola.rest.dtos.TipoCursoDtoRequest;
import com.tauan.api_escola.rest.dtos.TipoCursoDtoResponse;
import com.tauan.api_escola.services.TipoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo-curso")
public class TipoCursoController {
    @Autowired
    private TipoCursoService tipoCursoService;

    @PostMapping
    public ResponseEntity<TipoCursoDtoResponse> cadastrarTipoCurso(@RequestBody TipoCursoDtoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoCursoService.criarTipoCurso(request));
    }

    @GetMapping("/{idTipoCurso}")
    public ResponseEntity<TipoCursoDtoResponse> encontrarTipoCurso(@PathVariable("idTipoCurso") Long idTipoCurso) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoCursoService.buscarTipoCurso(idTipoCurso));
    }

    @PutMapping("/{idTipoCurso}")
    public ResponseEntity<TipoCursoDtoResponse> atualizarTipoCurso(
            @PathVariable("idTipoCurso") Long idTipoCurso,
            @RequestBody TipoCursoDtoRequest tipoCursoDtoRequest
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoCursoService.atualizarTipoCurso(idTipoCurso, tipoCursoDtoRequest));
    }

    @DeleteMapping("/{idTipoCurso}")
    public ResponseEntity<String> deletarTipoCurso(@PathVariable("idTipoCurso") Long idTipoCurso) {
        tipoCursoService.deletarTipoCurso(idTipoCurso);
        return ResponseEntity.status(HttpStatus.OK).body("Tipo de curso de ID: " + idTipoCurso + " deletado com sucesso.");
    }
}
