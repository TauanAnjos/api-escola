package com.tauan.api_escola.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_professor")
public class ProfessorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_titulo", nullable = false)
    private TituloModel titulo;
    @Column(nullable = false)
    private String nome;
    @Column(length = 1,nullable = false)
    private String sexo;// 'm' ou 'f'
    @Column(length = 1,nullable = false)
    private String estado_civil;// 's', 'c', 'v', 'd'
    @Column(nullable = false)
    private LocalDateTime dt_nascimento;
    @Column(nullable = false)
    private String telefone;

    public ProfessorModel() {
    }

    public ProfessorModel(Long id, TituloModel titulo, String nome, String sexo, String estado_civil, LocalDateTime dt_nascimento, String telefone) {
        this.id = id;
        this.titulo = titulo;
        this.nome = nome;
        this.sexo = sexo;
        this.estado_civil = estado_civil;
        this.dt_nascimento = dt_nascimento;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TituloModel getTitulo() {
        return titulo;
    }

    public void setTitulo(TituloModel titulo) {
        this.titulo = titulo;
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

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public LocalDateTime getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDateTime dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorModel that = (ProfessorModel) o;
        return Objects.equals(id, that.id) && Objects.equals(titulo, that.titulo) && Objects.equals(nome, that.nome) && Objects.equals(sexo, that.sexo) && Objects.equals(estado_civil, that.estado_civil) && Objects.equals(dt_nascimento, that.dt_nascimento) && Objects.equals(telefone, that.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, nome, sexo, estado_civil, dt_nascimento, telefone);
    }
}
