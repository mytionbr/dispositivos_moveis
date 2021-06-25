<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page import="com.escolaadmin.back.controller.AlunoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    Integer idade = Integer.parseInt(request.getParameter("idade"));
    
    AlunoController alunoController = new AlunoController();
    
    Aluno aluno = new Aluno(0, nome, email, idade);
    
    alunoController.addAluno(aluno);
  
    String url = "/escolaadmin/application/alunos/lista";
    response.sendRedirect(url);
%>