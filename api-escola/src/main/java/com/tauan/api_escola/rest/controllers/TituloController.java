package com.tauan.api_escola.rest.controllers;

import com.tauan.api_escola.rest.dtos.TituloDtoRequest;
import com.tauan.api_escola.rest.dtos.TituloDtoResponse;
import com.tauan.api_escola.services.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/titulo")
public class TituloController {
    @Autowired
    private TituloService tituloService;
    @PostMapping
    public ResponseEntity<TituloDtoResponse> cadastrarTitulo(@RequestBody TituloDtoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tituloService.criarTitulo(request));
    }

    @GetMapping("/{idTitulo}")
    public ResponseEntity<TituloDtoResponse> encontrarTitulo(@PathVariable("idTitulo") Long idTitulo) {
        return ResponseEntity.status(HttpStatus.OK).body(tituloService.buscarTitulo(idTitulo));
    }

    @PutMapping("/{idTitulo}")
    public ResponseEntity<TituloDtoResponse> atualizarTitulo(@PathVariable("idTitulo") Long idTitulo,
                                                             @RequestBody TituloDtoRequest tituloDtoRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(tituloService.atualizarTitulo(idTitulo, tituloDtoRequest));
    }

    @DeleteMapping("/{idTitulo}")
    public ResponseEntity<String> deletarTitulo(@PathVariable("idTitulo") Long idTitulo) {
        tituloService.deletarTitulo(idTitulo);
        return ResponseEntity.status(HttpStatus.OK).body("Título de ID: " + idTitulo + " deletado com sucesso.");
    }
}
