
package com.escolaadmin.back.model;

public class Nota {
    
    private int id;
    private Curso curso;
    private Aluno aluno;
    private int valor;
    private boolean aprovado;

    public Nota() {
    }

    public Nota(int id, Curso curso, Aluno aluno, int valor, boolean aprovado) {
        this.id = id;
        this.curso = curso;
        this.aluno = aluno;
        this.valor = valor;
        this.aprovado = aprovado;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
    
    
}
