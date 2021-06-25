<%@page import="com.escolaadmin.back.model.Professor"%>
<%@page import="com.escolaadmin.back.controller.ProfessorController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    Integer id = Integer.parseInt(request.getParameter("id"));
   
    System.out.println("sdsadasdasdasdsad" + id);
    
    ProfessorController professorController = new ProfessorController();
       
    professorController.deleteProfessorById(id);
  
    String url = "/escolaadmin/application/professores/lista";
    response.sendRedirect(url);
%>