package com.tauan.api_escola.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_cursa")
public class CursaModel {
    @EmbeddedId
    private CursaId id;
    @Column(nullable = false, unique = true)
    private Integer ano;
    @Column(nullable = false, unique = true)
    private Integer semestre;
    @Column(nullable = false, unique = true)
    private Integer faltas;
    @Column(nullable = true)
    private BigDecimal nota1;
    @Column(nullable = true)
    private BigDecimal nota2;
    @Column(nullable = true)
    private BigDecimal nota3;
    @Column(nullable = false)
    private boolean aprovado;
    @Embeddable
    public static class CursaId implements Serializable {
        private Integer id_aluno;
        private Integer id_disciplina;
    }
}
