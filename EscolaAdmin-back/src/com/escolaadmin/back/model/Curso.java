package com.escolaadmin.back.model;

import java.util.List;

public class Curso {
    
    private Integer id;
    private String nome;
    private String descricao;
    private Professor professor;
  
    private int numAulas;

    public Curso(Integer id, String nome, String descricao, Professor professor,  int numAulas) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.professor = professor;
        this.numAulas = numAulas;
    }

    public Curso() {
    }

    public Curso(Integer id) {
        this.id = id;
    }

     
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    public int getNumAulas() {
        return numAulas;
    }

    public void setNumAulas(int numAulas) {
        this.numAulas = numAulas;
    }
    
    

    
    
    
}
