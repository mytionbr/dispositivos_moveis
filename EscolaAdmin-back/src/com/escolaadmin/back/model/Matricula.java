
package com.escolaadmin.back.model;


public class Matricula {
    
    private Curso curso;
    private Aluno aluno;

    public Matricula() {
    }

    public Matricula(Curso curso, Aluno aluno) {
        this.curso = curso;
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Matricula{" + "curso=" + curso + ", aluno=" + aluno + '}';
    }
    
    
}
