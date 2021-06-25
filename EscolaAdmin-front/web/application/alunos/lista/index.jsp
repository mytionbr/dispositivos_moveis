<%@page import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.List"%>
<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page import="com.escolaadmin.back.controller.AlunoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%
    AlunoController alunoController = new AlunoController();
    List<Aluno> alunos = alunoController.listAlunos();
    pageContext.setAttribute("alunos", alunos);


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
            <h1 class="text-center">Alunos</h1>

            <table class="table table-hover ">

                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Email</th>
                        <th scope="col">Idade</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="aluno" items="${pageScope.alunos}">
                        <tr>
                            <th scope="row"><c:out value="${aluno.getId()}"/></th>
                            <td><c:out value="${aluno.getNome()}"/></td>
                            <td><c:out value="${aluno.getEmail()}"/></td>
                            <td><c:out value="${aluno.getIdade()}"/></td>
                            <td><a href="/escolaadmin/application/alunos/aluno?id=${aluno.getId()}">alterar</a></td>
                            <td><a href="excluirAluno.jsp?id=${aluno.getId()}">deletar</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table> 
        </div>


    </body>
</body>


</html>
