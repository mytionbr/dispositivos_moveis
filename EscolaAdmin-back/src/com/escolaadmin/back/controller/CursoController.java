package com.escolaadmin.back.controller;


import com.escolaadmin.back.dao.CursoDAO;
import com.escolaadmin.back.model.Curso;
import java.util.List;


public class CursoController {
    
    private final CursoDAO cursoDAO;
    
    public CursoController(){
        this.cursoDAO = new CursoDAO();
    }
    
    
    public void addCurso(Curso curso){
        this.cursoDAO.addCurso(curso);
    }
    
    public List<Curso> listCursos(){
        return this.cursoDAO.listCursos();
    }
    
    public Curso findCursoById(int id){
        return this.cursoDAO.findCursoById(id);
    }
    
    public void updateCurso(Curso curso){
        this.cursoDAO.updateCurso(curso);
    }
    
    public void deleteCursoById(int id){
        this.cursoDAO.deleteCurso(id);
    }
    
    public Curso findCursoByNome(String nome){
        return this.cursoDAO.findCursoByNome(nome);
    }
    
}
