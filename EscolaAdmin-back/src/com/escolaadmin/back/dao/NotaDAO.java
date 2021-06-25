
package com.escolaadmin.back.dao;

import com.escolaadmin.back.model.Aluno;
import com.escolaadmin.back.model.Aula;
import com.escolaadmin.back.model.Curso;
import com.escolaadmin.back.model.Nota;
import com.escolaadmin.back.model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotaDAO {

    private Connection con = null;

    public NotaDAO() {
        con = BancoConnection.getConnection();
    }
    
    public void addNota(Nota nota){
        String sql = "INSERT INTO nota (valor,aprovado,curso_id,aluno_id) VALUES (?,?,?,?)";
        
        try{
            con = BancoConnection.getConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1,nota.getValor());
            stmt.setBoolean(2,nota.isAprovado());
            stmt.setInt(3,nota.getCurso().getId());
            stmt.setInt(4,nota.getAluno().getId());

            
            stmt.execute();
            System.out.println("\nNota adicionanda com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
     
    public List<Nota> listNotas() {

        ArrayList<Nota> notas = new ArrayList<>();
        
        String sql = "SELECT * FROM nota";
        
        AlunoDAO alunoDAO = new AlunoDAO();
        CursoDAO cursoDAO = new CursoDAO();
        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
              
                Nota nota = new Nota();
                
                nota.setId(rs.getInt("nota_id"));
                nota.setAprovado(rs.getBoolean("aprovado"));
                nota.setAluno(alunoDAO.findAlunoById(rs.getInt("aluno_id")));
                nota.setCurso(cursoDAO.findCursoById(rs.getInt("curso_id")));
                
                notas.add(nota);
            }

            rs.close();
           
            return notas;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
      public void deleteNota(int id) {

        String sql = "DELETE FROM nota WHERE nota_id = ?";
        
        try {
            con = BancoConnection.getConnection();
           
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
    
            System.out.println("\nNota deletada do Banco de Dados com sucesso!\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }

    }
    
       public Nota findNotaById(int id) {

        Nota nota = new Nota();
        String sql = "SELECT * FROM nota WHERE nota_id = ?";
        
        AlunoDAO alunoDAO = new AlunoDAO();
        CursoDAO cursoDAO = new CursoDAO();
        
        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                nota.setId(rs.getInt("nota_id"));
                nota.setAprovado(rs.getBoolean("aprovado"));
                nota.setAluno(alunoDAO.findAlunoById(rs.getInt("aluno_id")));
                nota.setCurso(cursoDAO.findCursoById(rs.getInt("curso_id")));
              
            }
            return nota;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
       
    public void updateNota(Nota nota) {

        String sql = "UPDATE nota SET valor = ?, aprovado = ?,curso_id = ?,aluno_id = ? WHERE nota_id = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, nota.getValor());
            stmt.setBoolean(2, nota.isAprovado());
            stmt.setInt(3, nota.getCurso().getId());
            stmt.setInt(4, nota.getAluno().getId());
             stmt.setInt(5, nota.getId());
           
            
            
            stmt.executeUpdate();
            System.out.println("\nNota Editado com sucesso\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
}
