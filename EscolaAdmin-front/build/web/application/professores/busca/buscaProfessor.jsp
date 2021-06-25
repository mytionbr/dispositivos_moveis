<%@page import="com.escolaadmin.back.controller.ProfessorController"%>
<%@page import="com.escolaadmin.back.model.Professor"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    
   
    String email = request.getParameter("email");
        
         
    ProfessorController professorController = new ProfessorController();
    
    Professor professor = professorController.findProfessorByEmail(email);
    
    System.out.println(professor);
    
    String url = "/escolaadmin/application/professores/professor?id=" +  professor.getId();
    response.sendRedirect(url);
%>