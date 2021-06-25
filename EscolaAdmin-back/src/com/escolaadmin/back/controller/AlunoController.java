package com.escolaadmin.back.controller;

import com.escolaadmin.back.dao.AlunoDAO;
import com.escolaadmin.back.model.Aluno;
import java.util.List;


public class AlunoController {
    
    private final AlunoDAO alunoDAO;
    
    public AlunoController(){
        this.alunoDAO = new AlunoDAO();
    }
    
    
    public void addAluno(Aluno aluno){
        this.alunoDAO.addAluno(aluno);
    }
    
    public List<Aluno> listAlunos(){
        return this.alunoDAO.listAlunos();
    }
    
    public Aluno findAlunoById(int id){
        return this.alunoDAO.findAlunoById(id);
    }
    
    public void updateAluno(Aluno aluno){
        this.alunoDAO.updateAluno(aluno);
    }
    
    public void deleteAlunoById(int id){
        this.alunoDAO.deleteAluno(id);
    }
    
    public Aluno findAlunoByEmail(String email){
        return this.alunoDAO.findAlunoByEmail(email);
    }
    
     public Aluno findAlunoByNome(String nome){
        return this.alunoDAO.findAlunoByNome(nome);
    }
    
}
