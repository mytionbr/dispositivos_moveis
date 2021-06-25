<%@page import="com.escolaadmin.back.model.Professor"%>
<%@page import="com.escolaadmin.back.controller.ProfessorController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    Integer id = Integer.parseInt(request.getParameter("id"));
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");
    Integer idade = Integer.parseInt(request.getParameter("idade"));
    
    ProfessorController professorController = new ProfessorController();
    
    Professor professor = new Professor(id, nome, email, idade, senha);
    
    professorController.updateProfessor(professor);
  
    String url = "/escolaadmin/application/professores/lista";
    response.sendRedirect(url);
%>