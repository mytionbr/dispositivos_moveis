<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page import="com.escolaadmin.back.controller.AlunoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    Integer id = Integer.parseInt(request.getParameter("id"));
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    Integer idade = Integer.parseInt(request.getParameter("idade"));
    
    AlunoController alunoController = new AlunoController();
    
    Aluno aluno = new Aluno(id, nome, email, idade);
    
    alunoController.updateAluno(aluno);
  
    String url = "/escolaadmin/application/alunos/lista";
    response.sendRedirect(url);
%>