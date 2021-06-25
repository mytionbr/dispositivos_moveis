
package com.escolaadmin.back.model;

public class Professor {
    
    private int id;
    private String nome;
    private String email;
    private int idade;
    private String senha;

    public Professor() {
    }

    public Professor(int id) {
        this.id = id;
    }

    public Professor(int id, String nome, String email, int idade, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", idade=" + idade + ", senha=" + senha + '}';
    }
    
    
    
}
