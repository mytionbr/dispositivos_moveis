<%@page import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.List"%>
<%@page import="com.escolaadmin.back.model.Aluno"%>
<%@page import="com.escolaadmin.back.controller.AlunoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
     Integer id = Integer.parseInt(request.getParameter("id"));
     
     
     
     AlunoController alunoController = new AlunoController();
     
     Aluno aluno = alunoController.findAlunoById(id);
     pageContext.setAttribute("aluno", aluno);
   
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
            <h1 class="text-center">Alterar Aluno</h1>

            <form action="alteraAluno.jsp" method="post">
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp"
                           value=${aluno.getEmail()}>
                </div>
                <div class="mb-3">
                    <label for="nome" class="form-label">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome"
                           value=${aluno.getNome()}>
                </div>
                <div class="mb-3">
                    <label for="idade" class="form-label">Idade</label>
                    <input type="number" class="form-control" name="idade" id="idade"
                           value=${aluno.getIdade()}>
                </div>
                <input type="hidden" name="id" id="id"
                           value=${aluno.getId()}>
                <button type="submit" class="btn btn-primary">Salvar</button>
            </form>
        </div>


    </body>
</body>


</html>
