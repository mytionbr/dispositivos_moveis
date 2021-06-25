<%@page import="com.escolaadmin.back.controller.AlunoController"%>
<%@page import="com.escolaadmin.back.model.Aluno"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    
   
    String email = request.getParameter("email");
        
        System.out.println("dsfd sdf " + email);         
    System.out.println("dsfd sdf " + email);         
    System.out.println("dsfd sdf " + email);         
    System.out.println("dsfd sdf " + email);         
    System.out.println("dsfd sdf " + email);         
System.out.println("dsfd sdf " + email);         
    AlunoController alunoController = new AlunoController();
    
    Aluno aluno = alunoController.findAlunoByEmail(email);
    
    
  
    String url = "/escolaadmin/application/alunos/aluno?id=" +  aluno.getId();
    response.sendRedirect(url);
%>