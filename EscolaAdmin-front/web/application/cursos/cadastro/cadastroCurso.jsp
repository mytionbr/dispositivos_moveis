<%@page import="com.escolaadmin.back.model.Professor"%>
<%@page import="com.escolaadmin.back.model.Curso"%>
<%@page import="com.escolaadmin.back.controller.CursoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    String nome = request.getParameter("nome");
    String descricao = request.getParameter("descricao");
    Integer professorId = Integer.parseInt(request.getParameter("professor"));
    
    Professor professor = new Professor(professorId);
    
    CursoController cursoController = new CursoController();
    
    Curso curso = new Curso();
    curso.setNome(nome);
    curso.setDescricao(descricao);
    curso.setProfessor(professor);
    cursoController.addCurso(curso);
  
    String url = "/escolaadmin/application/cursos/lista";
    response.sendRedirect(url);
%>