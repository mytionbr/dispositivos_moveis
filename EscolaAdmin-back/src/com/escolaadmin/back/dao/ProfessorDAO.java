
package com.escolaadmin.back.dao;

import com.escolaadmin.back.model.Aluno;
import com.escolaadmin.back.model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    private Connection con = null;

    public ProfessorDAO() {
        con = BancoConnection.getConnection();
    }
    
    public void addProfessor(Professor professor){
        String sql = "INSERT INTO professor (nome,idade,email,senha) VALUES (?,?,?,?)";
        
        try{
            con = BancoConnection.getConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1,professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3,professor.getEmail());
            stmt.setString(4,professor.getSenha());
            
            stmt.execute();
            System.out.println("\nProfessor adicionando com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
     
    public List<Professor> listProfessores() {

        ArrayList<Professor> professores = new ArrayList<>();
        
        String sql = "SELECT * FROM professor";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
              
                Professor professor = new Professor();
                             
                professor.setId(rs.getInt("professor_id"));
                professor.setIdade(rs.getInt("idade"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setSenha(rs.getString("senha"));
                
                professores.add(professor);
            }

            rs.close();
           
            return professores;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
      public void deleteProfessor(int id) {
        String sql1 = "UPDATE curso SET professor_id = null  WHERE professor_id = ?";
        String sql2 = "DELETE FROM professor WHERE professor_id = ?";
        
 
        
        try {
            con = BancoConnection.getConnection();
           
            PreparedStatement stmt1 = con.prepareStatement(sql1);
           
            stmt1.setInt(1, id);
            stmt1.executeUpdate();
            
            PreparedStatement stmt2 = con.prepareStatement(sql2);
            
            stmt2.setInt(1, id);
            stmt2.executeUpdate();
            
       
            System.out.println("\nProfessor deletado do Banco de Dados com sucesso!\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }

    }
    
       public Professor findProfessorById(int id) {

        Professor professor = new Professor();
        String sql = "SELECT * FROM professor WHERE professor_id = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                professor.setId(rs.getInt("professor_id"));
                professor.setNome(rs.getString("nome"));
                professor.setIdade(rs.getInt("idade"));
                professor.setEmail(rs.getString("email"));
                professor.setSenha(rs.getString("senha"));
            }
            return professor;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
       
    public void updateProfessor(Professor professor) {

        String sql = "UPDATE professor SET nome = ?, idade = ?, email = ?, senha = ? WHERE professor_id = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade()); 
            stmt.setString(3, professor.getEmail());
            stmt.setString(4, professor.getSenha());
            stmt.setInt(5,professor.getId());
            
            
            stmt.executeUpdate();
            System.out.println("\nProfessor Editado com sucesso\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
    public Professor findProfessorByEmail(String email) {
        Professor professor = new Professor();
        String sql = "SELECT * FROM professor WHERE email = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                professor.setId(rs.getInt("professor_id"));
                professor.setNome(rs.getString("nome"));
                professor.setIdade(rs.getInt("idade"));
                professor.setEmail(rs.getString("email"));
              
            }
            return professor;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
}
