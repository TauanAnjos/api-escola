package com.tauan.api_escola.models;

import com.tauan.api_escola.rest.dtos.LecionaDtoResponse;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_leciona")
public class LecionaModel {
    @EmbeddedId
    private LecionaId id;

    public LecionaDtoResponse toDtoResponse() {
        return new LecionaDtoResponse(this.id);
    }

    @Embeddable
    public static class LecionaId implements Serializable {
        @Column(name = "id_professor")
        private Integer idProfessor;

        @Column(name = "id_disciplina")
        private Integer idDisciplina;

        public Integer getIdProfessor() {
            return idProfessor;
        }

        public void setIdProfessor(Integer idProfessor) {
            this.idProfessor = idProfessor;
        }

        public Integer getIdDisciplina() {
            return idDisciplina;
        }

        public void setIdDisciplina(Integer idDisciplina) {
            this.idDisciplina = idDisciplina;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LecionaId lecionaId = (LecionaId) o;
            return Objects.equals(idProfessor, lecionaId.idProfessor) && Objects.equals(idDisciplina, lecionaId.idDisciplina);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idProfessor, idDisciplina);
        }
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
