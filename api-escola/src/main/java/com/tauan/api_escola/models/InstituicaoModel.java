package com.tauan.api_escola.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_instituicao")
public class InstituicaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15, nullable = false)
    private String sigla;
    @Column(length = 15, nullable = false)
    private String descricao;
}
