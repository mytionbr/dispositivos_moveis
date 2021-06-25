<%@page import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.List"%>
<%@page import="com.escolaadmin.back.model.Curso"%>
<%@page import="com.escolaadmin.back.controller.CursoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%
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
            <h1 class="text-center">Cursos</h1>

            <table class="table table-hover ">

                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Professor</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="curso" items="${pageScope.cursos}">
                        <tr>
                            <th scope="row"><c:out value="${curso.getId()}"/></th>
                            <td><c:out value="${curso.getNome()}"/></td>
                            <td><c:out value="${curso.getDescricao()}"/></td>
                            <td><c:out value="${curso.getProfessor().getNome()}"/></td>
                            <td><a href="/escolaadmin/application/cursos/curso?id=${curso.getId()}">alterar</a></td>
                            <td><a href="excluirCurso.jsp?id=${curso.getId()}">deletar</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table> 
        </div>


    </body>
</body>


</html>
