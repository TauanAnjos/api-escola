package com.tauan.api_escola.rest.controllers;

import com.tauan.api_escola.rest.dtos.InstituicaoDtoRequest;
import com.tauan.api_escola.rest.dtos.InstituicaoDtoResponse;
import com.tauan.api_escola.services.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {
    @Autowired
    private InstituicaoService instituicaoService;

    @PostMapping
    public ResponseEntity<InstituicaoDtoResponse> cadastrarInstituicao(@RequestBody InstituicaoDtoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(instituicaoService.criarInstituicao(request));
    }

    @GetMapping("/{idInstituicao}")
    public ResponseEntity<InstituicaoDtoResponse> encontrarInstituicao(@PathVariable("idInstituicao") Long idInstituicao){
        return ResponseEntity.status(HttpStatus.OK).body(instituicaoService.buscarInstituicao(idInstituicao));
    }

    @PutMapping("/{idInstituicao}")
    public ResponseEntity<InstituicaoDtoResponse> atualizarInstituicao(@PathVariable("idInstituicao") Long idInstituicao, @RequestBody InstituicaoDtoRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(instituicaoService.atualizarInstituicao(idInstituicao, request));
    }

    @DeleteMapping("/{idInstituicao}")
    public ResponseEntity<String> deletarInstituicao(@PathVariable("idInstituicao") Long idInstituicao){
        instituicaoService.deletarInstituicao(idInstituicao);
        return ResponseEntity.status(HttpStatus.OK).body("Instituição de ID: " + idInstituicao + " deletada com sucesso.");
    }
}
