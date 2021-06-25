<%@page import="com.escolaadmin.back.model.Professor"%>
<%@page import="com.escolaadmin.back.controller.ProfessorController"%>
<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");
    Integer idade = Integer.parseInt(request.getParameter("idade"));
    
    ProfessorController professorController = new ProfessorController();
    
    Professor professor = new Professor(0, nome, email, idade, senha);
    
    professorController.addProfessor(professor);
  
    String url = "/escolaadmin/application/professores/lista";
    response.sendRedirect(url);
%>