package com.tauan.api_escola.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tipo_disciplina")
public class TipoDisciplinaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
}
