
package com.escolaadmin.back.dao;

import com.escolaadmin.back.model.Aluno;
import com.escolaadmin.back.model.Curso;
import com.escolaadmin.back.model.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    private Connection con = null;

    public MatriculaDAO() {
        con = BancoConnection.getConnection();
    }
    
    public void addMatricula(Matricula matricula){
        String sql = "INSERT INTO curso_aluno (curso_id,aluno_id)  VALUES (?,?)";
        
        try{
            con = BancoConnection.getConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, matricula.getCurso().getId());
            stmt.setInt(2, matricula.getAluno().getId());
            
            
            stmt.execute();
            System.out.println("\nMatricula adicionando com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
     
    public List<Matricula> listMatriculas() {

        ArrayList<Matricula> matriculas = new ArrayList<>();
        
        String sql = "SELECT * FROM curso_aluno";

        AlunoDAO alunoDAO = new AlunoDAO();
        CursoDAO cursoDAO = new CursoDAO();
        try {
            con = BancoConnection.getConnection();
            System.out.println(con);
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
              
                Matricula matricula = new Matricula();
                             
                matricula.setAluno(alunoDAO.findAlunoById(rs.getInt("aluno_id")));
                matricula.setCurso(cursoDAO.findCursoById(rs.getInt("curso_id")));

                matriculas.add(matricula);
            }

            rs.close();
           
            return matriculas;

        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
      public void deleteMatricula(int alunoId,int cursoId) {

        String sql = "DELETE FROM curso_aluno WHERE aluno_id = ? and curso_id = ?";
        
        
        try {
            con = BancoConnection.getConnection();
           
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, alunoId);
            stmt.setInt(2, cursoId);
            
            stmt.executeUpdate();
            
            
            System.out.println("\nMatricula deletado do Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }

    }
    
       public List<Matricula> findMatriculaByCursoAndMatricula(int cursoId,int alunoId) {

        List<Matricula> matriculas = new ArrayList<>();
        
        String sql = "SELECT * FROM curso_aluno WHERE curso_id = ? and aluno_id = ?";

        AlunoDAO alunoDAO = new AlunoDAO();
        CursoDAO cursoDAO = new CursoDAO();
        
        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cursoId);
            stmt.setInt(2, alunoId);
            ResultSet rs = stmt.executeQuery();
            
            Curso curso = cursoDAO.findCursoById(cursoId);
            
            while (rs.next()) {
                
                Matricula matricula = new Matricula();
                             
                matricula.setAluno(alunoDAO.findAlunoById(rs.getInt("aluno_id")));
                matricula.setCurso(curso);

                matriculas.add(matricula);

            }
            return matriculas;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
       
    public void updateMatricula(Matricula matricula) {

        String sql = "UPDATE curso_aluno SET curso_id = ?, aluno_id = ? WHERE curso_id = ? and aluno_id";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, matricula.getCurso().getId());
            stmt.setInt(2,matricula.getAluno().getId());
            stmt.setInt(3,matricula.getCurso().getId());
            stmt.setInt(4,matricula.getAluno().getId());
            
            
            stmt.executeUpdate();
            System.out.println("\nMatricula Editado com sucesso\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    public List<Matricula> findMatriculaByCurso(int cursoId) {
        
        List<Matricula> matriculas = new ArrayList<>();
        
        String sql = "SELECT * FROM curso_aluno WHERE curso_id = ?";

        AlunoDAO alunoDAO = new AlunoDAO();
        CursoDAO cursoDAO = new CursoDAO();
        
        Curso cursoData = cursoDAO.findCursoById(cursoId);
        
        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,cursoId);
            ResultSet rs = stmt.executeQuery();
            
           
            
            while (rs.next()) {
                
                Matricula matricula = new Matricula();
                             
                matricula.setAluno(alunoDAO.findAlunoById(rs.getInt("curso_id")));
                matricula.setCurso(cursoData);

                matriculas.add(matricula);

            }
            return matriculas;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
    
     public List<Matricula> findMatriculaByAluno(int alunoId) {
        
        List<Matricula> matriculas = new ArrayList<>();
        
        String sql = "SELECT * FROM curso_aluno WHERE aluno_id = ?";

        AlunoDAO alunoDAO = new AlunoDAO();
        CursoDAO cursoDAO = new CursoDAO();
        
        Aluno alunoData =alunoDAO.findAlunoById(alunoId);
        
        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,alunoId);
            ResultSet rs = stmt.executeQuery();
            
           
            
            while (rs.next()) {
                
                Matricula matricula = new Matricula();
                             
                matricula.setAluno(alunoData);
                matricula.setCurso(cursoDAO.findCursoById(rs.getInt("curso_id")));

                matriculas.add(matricula);

            }
            return matriculas;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
}
