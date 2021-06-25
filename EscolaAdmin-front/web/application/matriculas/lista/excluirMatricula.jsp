<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page import="com.escolaadmin.back.controller.MatriculaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    Integer alunoId = Integer.parseInt(request.getParameter("idAluno"));
    Integer cursoId = Integer.parseInt(request.getParameter("idCurso"));
   
    System.out.println(alunoId + " " +cursoId);
    
    MatriculaController matriculaController = new MatriculaController();
     
    matriculaController.deleteMatriculaByCursoId(cursoId, alunoId);
  
    String url = "/escolaadmin/application/matriculas/lista";
    response.sendRedirect(url);
%>