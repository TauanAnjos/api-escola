package com.tauan.api_escola.models;

import com.tauan.api_escola.rest.dtos.AlunoDtoResponse;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_aluno")
public class AlunoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255,nullable = false, unique = true)
    private String nome;
    @Column(length = 1, nullable = false, unique = true)
    private String sexo;// 'm' , 'f'
    @Column(nullable = false, unique = true)
    private LocalDateTime dt_nascimento;

    public AlunoModel() {
    }

    public AlunoModel(Long id, String nome, String sexo, LocalDateTime dt_nascimento) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dt_nascimento = dt_nascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDateTime getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDateTime dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoModel that = (AlunoModel) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(sexo, that.sexo) && Objects.equals(dt_nascimento, that.dt_nascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sexo, dt_nascimento);
    }

    public AlunoDtoResponse toDtoResponse() {
        return new AlunoDtoResponse(this.id,this.nome,this.sexo,this.dt_nascimento);
    }
}
