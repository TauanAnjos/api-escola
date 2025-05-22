package com.tauan.api_escola.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tipo_curso")
public class TipoCursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
}
