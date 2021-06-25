package com.escolaadmin.back.dao;

import com.escolaadmin.back.model.Aluno;
import com.escolaadmin.back.model.Curso;
import com.escolaadmin.back.model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class CursoDAO {

    private Connection con = null;

    public CursoDAO() {
        con = BancoConnection.getConnection();
    }

    public void addCurso(Curso curso) {
        String sql = "INSERT INTO curso (nome,descricao,professor_id)  VALUES (?,?,?)";

        try {
            con = BancoConnection.getConnection();

            PreparedStatement stmt1 = con.prepareStatement(sql);

            stmt1.setString(1, curso.getNome());
            stmt1.setString(2, curso.getDescricao());
            stmt1.setInt(3, curso.getProfessor().getId());

            stmt1.execute();

            System.out.println("\nCurso adicionando com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    public List<Curso> listCursos() {

        ArrayList<Curso> cursos = new ArrayList<>();

        String sql = "SELECT * FROM curso";

        ProfessorDAO professorDAO = new ProfessorDAO();

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Curso curso = new Curso();

                curso.setId(rs.getInt("curso_id"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setNome(rs.getString("nome"));
                curso.setProfessor(professorDAO.findProfessorById(rs.getInt("professor_id")));

                cursos.add(curso);
            }

            rs.close();

            return cursos;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    public void deleteCurso(int id) {

        String sql4 = "DELETE FROM curso WHERE curso_id = ?";
        String sql3 = "DELETE FROM curso_aluno WHERE curso_id = ?";
        String sql1 = "DELETE FROM aula WHERE curso_id = ?";
        String sql2 = "DELETE FROM nota WHERE curso_id = ?";

        try {
            con = BancoConnection.getConnection();

            PreparedStatement stmt1 = con.prepareStatement(sql1);

            stmt1.setInt(1, id);
            stmt1.execute();

            PreparedStatement stmt2 = con.prepareStatement(sql2);

            stmt2.setInt(1, id);
            stmt2.execute();

            PreparedStatement stmt3 = con.prepareStatement(sql3);

            stmt3.setInt(1, id);
            stmt3.execute();

            PreparedStatement stmt4 = con.prepareStatement(sql4);

            stmt4.setInt(1, id);
            stmt4.execute();

            System.out.println("\nCurso deletado do Banco de Dados com sucesso!\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }

    }

    public Curso findCursoById(int id) {

        Curso curso = new Curso();
        String sql = "SELECT * FROM curso WHERE curso_id = ?";
        ProfessorDAO professorDAO = new ProfessorDAO();
        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                curso.setId(rs.getInt("curso_id"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setNome(rs.getString("nome"));
                curso.setProfessor(professorDAO.findProfessorById(rs.getInt("professor_id")));

            }
            return curso;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    public void updateCurso(Curso curso) {

        String sql = "UPDATE curso SET nome = ?, descricao = ?, professor_id=? WHERE curso_id = ?";

        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getDescricao());
            stmt.setInt(3, curso.getProfessor().getId());
            stmt.setInt(4, curso.getId());

            stmt.executeUpdate();
            System.out.println("\nCurso Editado com sucesso\n");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

    public Curso findCursoByNome(String nome) {
        Curso curso = new Curso();
        String sql = "SELECT * FROM curso WHERE nome = ?";
        ProfessorDAO professorDAO = new ProfessorDAO();
        try {
            con = BancoConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                curso.setId(rs.getInt("curso_id"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setNome(rs.getString("nome"));
                curso.setProfessor(professorDAO.findProfessorById(rs.getInt("professor_id")));

            }
            return curso;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return null;
        } finally {
            BancoConnection.closeConnection(con);
        }
    }

}
