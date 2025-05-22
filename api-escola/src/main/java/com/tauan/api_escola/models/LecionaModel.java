package com.tauan.api_escola.models;

import jakarta.persistence.*;

import java.io.Serializable;

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
}
