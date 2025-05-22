package com.tauan.api_escola.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

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

    public DisciplinaModel() {
    }

    public DisciplinaModel(Long id, CursoModel curso, TipoDisciplinaModel tipoDisciplina, String sigla, String descricao, Integer periodo, Integer carga_horaria) {
        this.id = id;
        this.curso = curso;
        this.tipoDisciplina = tipoDisciplina;
        this.sigla = sigla;
        this.descricao = descricao;
        this.periodo = periodo;
        this.carga_horaria = carga_horaria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CursoModel getCurso() {
        return curso;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }

    public TipoDisciplinaModel getTipoDisciplina() {
        return tipoDisciplina;
    }

    public void setTipoDisciplina(TipoDisciplinaModel tipoDisciplina) {
        this.tipoDisciplina = tipoDisciplina;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplinaModel that = (DisciplinaModel) o;
        return Objects.equals(id, that.id) && Objects.equals(curso, that.curso) && Objects.equals(tipoDisciplina, that.tipoDisciplina) && Objects.equals(sigla, that.sigla) && Objects.equals(descricao, that.descricao) && Objects.equals(periodo, that.periodo) && Objects.equals(carga_horaria, that.carga_horaria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, curso, tipoDisciplina, sigla, descricao, periodo, carga_horaria);
    }
}
