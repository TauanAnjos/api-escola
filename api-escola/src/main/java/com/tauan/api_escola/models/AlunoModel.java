package com.tauan.api_escola.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_aluno")
public class AlunoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255,nullable = false, unique = true)
    private String nome;
    @Column(length = 1, nullable = false, unique = true)
    private String sexo;// 'm' , 'f'
    @Column(nullable = false, unique = true)
    private LocalDateTime dt_nascimento;
}
