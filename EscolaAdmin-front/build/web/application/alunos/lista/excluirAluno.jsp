<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page import="com.escolaadmin.back.controller.AlunoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    Integer id = Integer.parseInt(request.getParameter("id"));
   
    
    AlunoController alunoController = new AlunoController();
       
    alunoController.deleteAlunoById(id);
  
    String url = "/escolaadmin/application/alunos/lista";
    response.sendRedirect(url);
%>