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
    Integer id = Integer.parseInt(request.getParameter("id"));

    CursoController cursoController = new CursoController();

    Curso curso = cursoController.findCursoById(id);
    pageContext.setAttribute("curso", curso);
    
    ProfessorController professorController = new ProfessorController();
    
    List<Professor> professores = professorController.listProfessores();
    pageContext.setAttribute("professores", professores);

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
            <h1 class="text-center">Alterar Curso</h1>

            <form action="alteraCurso.jsp" method="post">
                <div class="mb-3">
                    <label for="nome" class="form-label">Nome</label>
                    <input type="text" class="form-control" id="nome" name="nome" value="${curso.getNome()}">
                </div>
                <div class="mb-3">
                    <label for="descricao" class="form-label">Descrição</label>
                    <textarea class="form-control" name="descricao" id="descricao" rows="3" >${curso.getDescricao()}</textarea>
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="professor">Professor</label>
                    </div>
                    <select class="custom-select" id="professor" name="professor">
                        <c:forEach var="professor" items="${pageScope.professores}">
                            
                            <c:choose>
                                <c:when test="${professor.getId() == curso.getProfessor().getId()}">
                                    <option value="${professor.getId()}">${professor.getNome()}</option>
                                  
                                </c:when>    
                                <c:otherwise>
                                    <option value="${professor.getId()}">${professor.getNome()}</option>
                                    
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                    </select>
                </div>
                
                <input type="hidden" name="id" id="id"
                           value=${curso.getId()}>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>


    </body>
</body>


</html>
