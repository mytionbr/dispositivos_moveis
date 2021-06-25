<%@page import="com.escolaadmin.back.controller.AlunoController"%>
<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page import="com.escolaadmin.back.controller.MatriculaController"%>
<%@page import="com.escolaadmin.back.controller.CursoController"%>
<%@page import="com.escolaadmin.back.model.Curso"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
  String nome = request.getParameter("nome");
        
                 
    MatriculaController matriculaController = new MatriculaController();
    
    AlunoController alunoController = new AlunoController();
    
    Aluno aluno = alunoController.findAlunoByNome(nome);
   
    String url = "/escolaadmin/application/matriculas/matricula?alunoId=" +  aluno.getId();
    response.sendRedirect(url);
%>