<%@page import="com.escolaadmin.back.controller.MatriculaController"%>
<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page import="com.escolaadmin.back.model.Matricula"%>
<%@page import="com.escolaadmin.back.model.Professor"%>
<%@page import="com.escolaadmin.back.model.Curso"%>
<%@page import="com.escolaadmin.back.controller.CursoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
    
   
    Integer cursoId = Integer.parseInt(request.getParameter("curso"));
    Integer alunoId = Integer.parseInt(request.getParameter("aluno"));
    
    
    System.out.println(cursoId+"   "+alunoId);
    
    
    Curso curso =  new Curso(cursoId);
    Aluno aluno = new Aluno(alunoId);
    Matricula matricula = new Matricula(curso, aluno);
    
    MatriculaController matriculaCotroller = new MatriculaController();
        
    matriculaCotroller.addMatricula(matricula);
  
    String url = "/escolaadmin/application/matriculas/lista";
    response.sendRedirect(url);
%>