<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page import="com.escolaadmin.back.controller.AlunoController"%>
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
    AlunoController alunoController = new AlunoController();
    
    List<Aluno> alunos = alunoController.listAlunos();
    pageContext.setAttribute("alunos", alunos);
    
    CursoController cursoController = new CursoController();
    
    List<Curso> cursos = cursoController.listCursos();
    pageContext.setAttribute("cursos", cursos);

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    </head>
    <body>

        <c:import url="/jsp/header.jsp" />


        <div class="container">
            <h1 class="text-center">Cadastrar Matricula</h1>

            <form action="cadastroMatricula.jsp" method="post">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="curso">Curso</label>
                    </div>
                    <select class="custom-select" id="curso" name="curso">
                        <c:forEach var="curso" items="${pageScope.cursos}">
                             <option value="${curso.getId()}">${curso.getNome()}</option>
                        </c:forEach>
                                             
                    </select>
                </div>
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="aluno">Aluno</label>
                    </div>
                    <select class="custom-select" id="aluno" name="aluno">
                        <c:forEach var="aluno" items="${pageScope.alunos}">
                             <option value="${aluno.getId()}">${aluno.getNome()}</option>
                        </c:forEach>
                                             
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>


    </body>
</body>


</html>
