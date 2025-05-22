package com.tauan.api_escola.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_disciplina")
public class DisciplinaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private CursoModel curso;
    @ManyToOne
    @JoinColumn(name = "id_tipo_disciplina", nullable = false)
    private TipoDisciplinaModel tipoDisciplina;
    @Column(nullable = false, unique = true)
    private String sigla;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Integer periodo;
    @Column(nullable = false)
    private Integer carga_horaria;
}
