<%@page import="com.escolaadmin.back.model.Matricula"%>
<%@page import="com.escolaadmin.back.controller.MatriculaController"%>
<%@page import="com.escolaadmin.back.model.Professor"%>
<%@page import="com.escolaadmin.back.controller.ProfessorController"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.List"%>
<%@page import="com.escolaadmin.back.model.Curso"%>
<%@page import="com.escolaadmin.back.controller.CursoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
    
    

    MatriculaController matriculaController = new MatriculaController();
    
    List<Matricula> matriculas = new ArrayList<>();
    
    if(request.getParameter("cursoId") != null){
        Integer cursoId = Integer.parseInt(request.getParameter("cursoId"));
        matriculas = matriculaController.findMatriculasByCurso(cursoId);
    }
    
    if( request.getParameter("alunoId") != null){
        Integer alunoId = Integer.parseInt(request.getParameter("alunoId"));
        matriculas = matriculaController.findMatriculasByAluno(alunoId);
    }
   
    
    pageContext.setAttribute("matriculas", matriculas);
    

%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    </head>
    <body>

        <c:import url="/jsp/header.jsp" />


            
        <div class="container">
            <h1 class="text-center">Matriculas</h1>

            <table class="table table-hover ">

                <thead>
                    <tr>
                        <th scope="col">Curso</th>
                        <th scope="col">Aluno</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="matricula" items="${pageScope.matriculas}">
                        <tr>
                            <td><c:out value="${matricula.getCurso().getNome()}"/></td>
                            <td><c:out value="${matricula.getAluno().getNome()}"/></td>
                            
                            <td><a href="excluirMatricula.jsp?idCurso=${matricula.getCurso().getId()}&idAluno=${matricula.getAluno().getId()}">deletar</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table> 
        </div>


    </body>
</body>


</html>
