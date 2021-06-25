
package com.escolaadmin.back.dao;

import com.escolaadmin.back.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private Connection con = null;

    public AlunoDAO() {
        con = BancoConnection.getConnection();
    }
    
    public void addAluno(Aluno aluno){
        String sql = "INSERT INTO aluno (nome,email,idade) VALUES (?,?,?)";
        
        try{
            con = BancoConnection.getConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1,aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setInt(3, aluno.getIdade());
            
            stmt.execute();
            System.out.println("\nAluno adicionando com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
     
    public List<Aluno> listAlunos() {

        ArrayList<Aluno> alunos = new ArrayList<>();
        
        String sql = "SELECT * FROM aluno";

        try {
            con = BancoConnection.getConnection();
            System.out.println(con);
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
              
                Aluno aluno = new Aluno();
                             
                aluno.setId(rs.getInt("aluno_id"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                
                alunos.add(aluno);
            }

            rs.close();
           
            return alunos;

        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
      public void deleteAluno(int id) {

        String sql1 = "DELETE FROM aluno WHERE aluno_id = ?";
        String sql2 = "DELETE FROM curso_aluno WHERE aluno_id = ?";
        String sql3 = "DELETE FROM nota WHERE aluno_id = ?";
        
        try {
            con = BancoConnection.getConnection();
           
            PreparedStatement stmt1 = con.prepareStatement(sql1);
           
            stmt1.setInt(1, id);
            stmt1.executeUpdate();
            
            PreparedStatement stmt2 = con.prepareStatement(sql2);
            
            stmt2.setInt(1, id);
            stmt2.executeUpdate();
            
            PreparedStatement stmt3 = con.prepareStatement(sql3);
            
            stmt3.setInt(1, id);
            stmt3.executeUpdate();
            System.out.println("\nAluno deletado do Banco de Dados\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }

    }
    
       public Aluno findAlunoById(int id) {

        Aluno aluno = new Aluno();
        String sql = "SELECT * FROM aluno WHERE aluno_id = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                aluno.setId(rs.getInt("aluno_id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEmail(rs.getString("email"));
              
            }
            return aluno;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
       
    public void updateAluno(Aluno aluno) {

        String sql = "UPDATE aluno SET nome = ?, email = ?, idade = ? WHERE aluno_id = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setInt(3, aluno.getIdade());
            stmt.setInt(4,aluno.getId());
            
            
            stmt.executeUpdate();
            System.out.println("\nAluno Editado com sucesso\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    public Aluno findAlunoByEmail(String email) {
        Aluno aluno = new Aluno();
        String sql = "SELECT * FROM aluno WHERE email = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                aluno.setId(rs.getInt("aluno_id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEmail(rs.getString("email"));
              
            }
            return aluno;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    public Aluno findAlunoByNome(String nome) {
        
        Aluno aluno = new Aluno();
        String sql = "SELECT * FROM aluno WHERE nome = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                aluno.setId(rs.getInt("aluno_id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEmail(rs.getString("email"));
              
            }
            return aluno;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }

    }
    
}
