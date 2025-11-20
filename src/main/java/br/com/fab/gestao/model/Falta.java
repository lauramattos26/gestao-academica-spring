package br.com.fab.gestao.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Falta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aluno; // (STRING)
    private String disciplina; // (STRING)
    private LocalDate data; // (LocalDate)
    private String justificativa;

    // GETTERS E SETTERS ABAIXO
    public Long getId() {
        return id;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}
