package com.tauan.api_escola.models;

import com.tauan.api_escola.rest.dtos.TipoCursoDtoResponse;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_tipo_curso")
public class TipoCursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;

    public TipoCursoModel() {
    }

    public TipoCursoModel(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        TipoCursoModel that = (TipoCursoModel) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }

    public TipoCursoDtoResponse toDtoResponse() {
        return new TipoCursoDtoResponse(this.id,this.descricao);
    }
}
