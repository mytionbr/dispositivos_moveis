<%@page import="com.escolaadmin.back.model.Curso"%>
<%@page import="com.escolaadmin.back.controller.CursoController"%>
<%@page import="com.escolaadmin.back.model.Professor"%>
<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page import="com.escolaadmin.back.controller.AlunoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    Integer id = Integer.parseInt(request.getParameter("id"));
    String nome = request.getParameter("nome");
    String descricao = request.getParameter("descricao");
    Integer professorId = Integer.parseInt(request.getParameter("professor"));
    
    Professor professor = new Professor(professorId);
    
    CursoController cursoController = new CursoController();
    
    Curso curso = new Curso(id, nome, descricao, professor,0);
    
    cursoController.updateCurso(curso);
  
    String url = "/escolaadmin/application/cursos/lista";
    response.sendRedirect(url);%>