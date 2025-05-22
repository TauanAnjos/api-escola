package com.tauan.api_escola.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_curso", uniqueConstraints = @UniqueConstraint(columnNames = {"id_instituicao", "id_tipo_curso"}))
public class CursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_instituicao")
    private InstituicaoModel instituicao;
    @ManyToOne
    @JoinColumn(name = "id_tipo_curso")
    private TipoCursoModel tipoCurso;
    @Column(nullable = false)
    private String descricao;
}
