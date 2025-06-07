package com.tauan.api_escola.models;

import com.tauan.api_escola.rest.dtos.CursaDtoResponse;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

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
        @Column(name = "id_aluno")
        private Integer id_aluno;
        @Column(name = "id_disciplina")
        private Integer id_disciplina;
        public Integer getId_aluno() {
            return id_aluno;
        }

        public void setId_aluno(Integer id_aluno) {
            this.id_aluno = id_aluno;
        }

        public Integer getId_disciplina() {
            return id_disciplina;
        }

        public void setId_disciplina(Integer id_disciplina) {
            this.id_disciplina = id_disciplina;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CursaId cursaId = (CursaId) o;
            return Objects.equals(id_aluno, cursaId.id_aluno) && Objects.equals(id_disciplina, cursaId.id_disciplina);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id_aluno, id_disciplina);
        }
    }

    public CursaModel() {
    }

    public CursaModel(CursaId id, Integer ano, Integer semestre, Integer faltas, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3, boolean aprovado) {
        this.id = id;
        this.ano = ano;
        this.semestre = semestre;
        this.faltas = faltas;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.aprovado = aprovado;
    }

    public CursaId getId() {
        return id;
    }

    public void setId(CursaId id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getNota3() {
        return nota3;
    }

    public void setNota3(BigDecimal nota3) {
        this.nota3 = nota3;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursaModel that = (CursaModel) o;
        return aprovado == that.aprovado && Objects.equals(id, that.id) && Objects.equals(ano, that.ano) && Objects.equals(semestre, that.semestre) && Objects.equals(faltas, that.faltas) && Objects.equals(nota1, that.nota1) && Objects.equals(nota2, that.nota2) && Objects.equals(nota3, that.nota3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ano, semestre, faltas, nota1, nota2, nota3, aprovado);
    }

    public CursaDtoResponse toDtoResponse(){
        return new CursaDtoResponse(this.id,this.ano,this.semestre,this.faltas,this.nota1,this.nota2,this.nota3,this.aprovado);
    }
}
