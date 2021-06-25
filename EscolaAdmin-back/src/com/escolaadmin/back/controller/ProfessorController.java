package com.escolaadmin.back.controller;


import com.escolaadmin.back.dao.ProfessorDAO;
import com.escolaadmin.back.model.Professor;
import java.util.List;


public class ProfessorController {
    
    private final ProfessorDAO professorDAO;
    
    public ProfessorController(){
        this.professorDAO = new ProfessorDAO();
    }
    
    
    public void addProfessor(Professor professor){
        this.professorDAO.addProfessor(professor);
    }
    
    public List<Professor> listProfessores(){
        return this.professorDAO.listProfessores();
    }
    
    public Professor findProfessorById(int id){
        return this.professorDAO.findProfessorById(id);
    }
    
    public void updateProfessor(Professor professor){
        this.professorDAO.updateProfessor(professor);
    }
    
    public void deleteProfessorById(int id){
        this.professorDAO.deleteProfessor(id);
    }
    
    public Professor findProfessorByEmail(String email){
        return this.professorDAO.findProfessorByEmail(email);
    }
    
}
