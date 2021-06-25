package com.escolaadmin.back.controller;

import com.escolaadmin.back.dao.AlunoDAO;
import com.escolaadmin.back.dao.MatriculaDAO;
import com.escolaadmin.back.model.Aluno;
import com.escolaadmin.back.model.Matricula;
import java.util.List;


public class MatriculaController {
    
    private final MatriculaDAO matriculaDAO;
    
    public MatriculaController(){
        this.matriculaDAO = new MatriculaDAO();
    }
    
    
    public void addMatricula(Matricula matricula){
        
        if(this.findMatriculasByCursoAndByAluno(matricula.getCurso().getId(), matricula.getAluno().getId()).size() == 0){
            this.matriculaDAO.addMatricula(matricula);
        }
        
    }
    
    public List<Matricula> listMatriculas(){
        return this.matriculaDAO.listMatriculas();
    }
    
    public List<Matricula> findMatriculasByCursoAndByAluno(int cursoId,int alunoId){
        return this.matriculaDAO.findMatriculaByCursoAndMatricula(cursoId,alunoId);
    }
    
    public List<Matricula> findMatriculasByAluno(int alunoId){
        return this.matriculaDAO.findMatriculaByAluno(alunoId);
    }
    
    public List<Matricula> findMatriculasByCurso(int cursoId){
        return this.matriculaDAO.findMatriculaByCurso(cursoId);
    }
    
    public void updateAluno(Matricula matricula){
        this.matriculaDAO.updateMatricula(matricula);
    }
    
    public void deleteMatriculaByCursoId(Integer cursoId,Integer alunoId){
       this.matriculaDAO.deleteMatricula(alunoId, cursoId);
    }
    
   
    
}
