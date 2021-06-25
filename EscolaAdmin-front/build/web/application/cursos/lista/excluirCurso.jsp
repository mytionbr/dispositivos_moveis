<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page import="com.escolaadmin.back.controller.CursoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    Integer id = Integer.parseInt(request.getParameter("id"));
   
    
    CursoController cursoController = new CursoController();
       
    cursoController.deleteCursoById(id);
  
    String url = "/escolaadmin/application/cursos/lista";
    response.sendRedirect(url);
%>