<%@page import="com.escolaadmin.back.controller.CursoController"%>
<%@page import="com.escolaadmin.back.model.Curso"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    
   
    String nome = request.getParameter("nome");
        
                 
    CursoController cursoController = new CursoController();
    
    Curso curso = cursoController.findCursoByNome(nome);
    
    
  
    String url = "/escolaadmin/application/cursos/curso?id=" +  curso.getId();
    response.sendRedirect(url);
%>