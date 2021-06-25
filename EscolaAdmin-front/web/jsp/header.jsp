<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String url = request.getRequestURI();
    String home = "/escolaadmin/application/alunos/";
    System.err.println(url);
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Escola Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

        <style>

            body {
                min-height: 100vh;
                min-height: -webkit-fill-available;
            }

            html {
                height: -webkit-fill-available;
            }

            main {
                display: flex;
                flex-wrap: nowrap;
                height: 100vh;
                height: -webkit-fill-available;
                max-height: 100vh;
                overflow-x: auto;
                overflow-y: hidden;
            }

        </style>

    </head>
    <body>
        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="/escolaadmin/application/home" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <span class="fs-4">Escola Admin</span>
                </a>

                <ul class="nav nav-pills">

                    <li class="nav-item"><a href="/escolaadmin/application/home" class="nav-link" aria-current="page">Home</a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Alunos
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/escolaadmin/application/alunos/lista">Listar</a></li>
                            <li><a class="dropdown-item" href="/escolaadmin/application/alunos/cadastro">Cadastrar</a></li>
                            <li><a class="dropdown-item" href="/escolaadmin/application/alunos/busca">Buscar</a></li>
                        </ul>
                    </li>
  
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Professor
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/escolaadmin/application/professores/lista">Listar</a></li>
                            <li><a class="dropdown-item" href="/escolaadmin/application/professores/cadastro">Cadastrar</a></li>
                            <li><a class="dropdown-item" href="/escolaadmin/application/professores/busca">Buscar</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Cursos
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/escolaadmin/application/cursos/lista">Listar</a></li>
                            <li><a class="dropdown-item" href="/escolaadmin/application/cursos/cadastro">Cadastrar</a></li>
                            <li><a class="dropdown-item" href="/escolaadmin/application/cursos/busca">Buscar</a></li>
                        </ul>
                    </li>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Matriculas
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/escolaadmin/application/matriculas/lista">Listar</a></li>
                            <li><a class="dropdown-item" href="/escolaadmin/application/matriculas/cadastro">Cadastrar</a></li>
                            <li><a class="dropdown-item" href="/escolaadmin/application/matriculas/buscaPorCurso">Buscar por curso</a></li>
                            <li><a class="dropdown-item" href="/escolaadmin/application/matriculas/buscaPorAluno">Buscar por aluno</a></li>

                        </ul>
                    </li>


                </ul>
            </header>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    </body>
</html>
