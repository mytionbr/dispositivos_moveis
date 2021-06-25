
package com.escolaadmin.back.model;

public class Aluno {
    
    private Integer id;
    private String nome;
    private String email;
    private int idade;
    

    public Aluno() {
    }

    public Aluno(Integer id) {
        this.id = id;
    }

    
    
    public Aluno(int id, String nome, String email, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", idade=" + idade + '}';
    }

   
    
    
    
}
