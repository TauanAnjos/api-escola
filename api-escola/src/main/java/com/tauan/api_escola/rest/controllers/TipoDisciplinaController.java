package com.tauan.api_escola.rest.controllers;

import com.tauan.api_escola.rest.dtos.TipoDisciplinaDtoRequest;
import com.tauan.api_escola.rest.dtos.TipoDisciplinaDtoResponse;
import com.tauan.api_escola.services.TipoDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo-disciplina")
public class TipoDisciplinaController {
    @Autowired
    private TipoDisciplinaService tipoDisciplinaService;

    @PostMapping
    public ResponseEntity<TipoDisciplinaDtoResponse> cadastrarTipoDisciplina(@RequestBody TipoDisciplinaDtoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoDisciplinaService.criarTipoDisciplina(request));
    }

    @GetMapping("/{idTipoDisciplina}")
    public ResponseEntity<TipoDisciplinaDtoResponse> encontrarTipoDisciplina(@PathVariable("idTipoDisciplina") Long idTipoDisciplina) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoDisciplinaService.buscarTipoDisciplina(idTipoDisciplina));
    }

    @PutMapping("/{idTipoDisciplina}")
    public ResponseEntity<TipoDisciplinaDtoResponse> atualizarTipoDisciplina(
            @PathVariable("idTipoDisciplina") Long idTipoDisciplina,
            @RequestBody TipoDisciplinaDtoRequest tipoDisciplinaDtoRequest
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoDisciplinaService.atualizarTipoDisciplina(idTipoDisciplina, tipoDisciplinaDtoRequest));
    }

    @DeleteMapping("/{idTipoDisciplina}")
    public ResponseEntity<String> deletarTipoDisciplina(@PathVariable("idTipoDisciplina") Long idTipoDisciplina) {
        tipoDisciplinaService.deletarTipoDisciplina(idTipoDisciplina);
        return ResponseEntity.status(HttpStatus.OK).body("Tipo de disciplina de ID: " + idTipoDisciplina + " deletado com sucesso.");
    }
}
