package com.tauan.api_escola.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_leciona")
public class LecionaModel {
    @EmbeddedId
    private LecionaId id;

    @Embeddable
    public static class LecionaId implements Serializable {
        @Column(name = "id_professor")
        private Integer idProfessor;

        @Column(name = "id_disciplina")
        private Integer idDisciplina;
    }

    public LecionaModel() {
    }

    public LecionaModel(LecionaId id) {
        this.id = id;
    }

    public LecionaId getId() {
        return id;
    }

    public void setId(LecionaId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LecionaModel that = (LecionaModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
