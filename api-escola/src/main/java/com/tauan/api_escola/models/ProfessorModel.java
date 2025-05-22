package com.tauan.api_escola.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_professor")
public class ProfessorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_titulo", nullable = false)
    private TituloModel titulo;
    @Column(nullable = false)
    private String nome;
    @Column(length = 1,nullable = false)
    private String sexo;// 'm' ou 'f'
    @Column(length = 1,nullable = false)
    private String estado_civil;// 's', 'c', 'v', 'd'
    @Column(nullable = false)
    private LocalDateTime dt_nascimento;
    @Column(nullable = false)
    private String telefone;

}
