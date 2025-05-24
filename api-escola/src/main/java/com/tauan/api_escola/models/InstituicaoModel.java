package com.tauan.api_escola.models;

import com.tauan.api_escola.rest.dtos.InstituicaoDtoResponse;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_instituicao")
public class InstituicaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15, nullable = false)
    private String sigla;
    @Column(length = 15, nullable = false)
    private String descricao;

    public InstituicaoModel() {
    }

    public InstituicaoModel(Long id, String sigla, String descricao) {
        this.id = id;
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstituicaoModel that = (InstituicaoModel) o;
        return Objects.equals(id, that.id) && Objects.equals(sigla, that.sigla) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sigla, descricao);
    }

    public InstituicaoDtoResponse toDtoResponse() {
        return new InstituicaoDtoResponse(this.id,this.sigla,this.descricao);
    }
}
