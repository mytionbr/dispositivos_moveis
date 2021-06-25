<%@page import="com.escolaadmin.back.controller.MatriculaController"%>
<%@page import="com.escolaadmin.back.controller.CursoController"%>
<%@page import="com.escolaadmin.back.model.Curso"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    
   
    String nome = request.getParameter("nome");
        
                 
    MatriculaController matriculaController = new MatriculaController();
    
    CursoController cursoController = new CursoController();
    
    Curso curso = cursoController.findCursoByNome(nome);
    
   
  
    String url = "/escolaadmin/application/matriculas/matricula?cursoId=" +  curso.getId();
    response.sendRedirect(url);
%>