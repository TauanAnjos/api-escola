package com.tauan.api_escola.models;

import com.tauan.api_escola.rest.dtos.CursoDtoResponse;
import jakarta.persistence.*;

import java.util.Objects;

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

    public CursoModel() {
    }

    public CursoModel(Long id, InstituicaoModel instituicao, TipoCursoModel tipoCurso, String descricao) {
        this.id = id;
        this.instituicao = instituicao;
        this.tipoCurso = tipoCurso;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstituicaoModel getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(InstituicaoModel instituicao) {
        this.instituicao = instituicao;
    }

    public TipoCursoModel getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(TipoCursoModel tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoModel that = (CursoModel) o;
        return Objects.equals(id, that.id) && Objects.equals(instituicao, that.instituicao) && Objects.equals(tipoCurso, that.tipoCurso) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instituicao, tipoCurso, descricao);
    }

    public CursoDtoResponse toDtoResponse() {
        return new CursoDtoResponse(this.id,this.instituicao,this.tipoCurso,this.descricao);
    }
}
