
package com.escolaadmin.back.dao;

import com.escolaadmin.back.model.Aluno;
import com.escolaadmin.back.model.Aula;
import com.escolaadmin.back.model.Curso;
import com.escolaadmin.back.model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AulaDAO {

    private Connection con = null;

    public AulaDAO() {
        con = BancoConnection.getConnection();
    }
    
    public void addAula(Aula aula,Curso curso){
        String sql = "INSERT INTO aula (nome,descricao,curso_id) VALUES (?,?,?)";
        
        try{
            con = BancoConnection.getConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1,aula.getNome());
            stmt.setString(2, aula.getDescricao());
            stmt.setInt(3, curso.getId());

            
            stmt.execute();
            System.out.println("\nAula adicionanda com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
     
    public List<Aula> listAulas() {

        ArrayList<Aula> aulas = new ArrayList<>();
        
        String sql = "SELECT * FROM aula";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
              
                Aula aula = new Aula();
                             
                aula.setId(rs.getInt("aula_id"));
                aula.setNome(rs.getString("nome"));
                aula.setDescricao(rs.getString("descricao"));
                
                aulas.add(aula);
            }

            rs.close();
           
            return aulas;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
      public void deleteAula(int id) {

        String sql = "DELETE FROM aula WHERE aula_id = ?";
 
        
        try {
            con = BancoConnection.getConnection();
           
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
    
            System.out.println("\nAula deletada do Banco de Dados com sucesso!\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }

    }
    
       public Aula findAulaById(int id) {

        Aula aula = new Aula();
        String sql = "SELECT * FROM aula WHERE aula_id = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                aula.setId(rs.getInt("aula_id"));
                aula.setNome(rs.getString("nome"));
                aula.setDescricao(rs.getString("descricao"));
              
            }
            return aula;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
       
    public void updateAula(Aula aula) {

        String sql = "UPDATE aula SET nome = ?, descricao = ? WHERE aula_id = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, aula.getNome());
            stmt.setString(2, aula.getDescricao());
            stmt.setInt(3,aula.getId());
            
            
            stmt.executeUpdate();
            System.out.println("\nProfessor Editado com sucesso\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }
    
}
