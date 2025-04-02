<%-- 
    Document   : index
    Created on : 25/03/2025, 9:10:56 a. m.
    Author     : Estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Principal</title>
    </head>
    <body>
        <header>
            <h1>Biblioteca</h1>   
        </header>
        <nav>
            <ul>
                <li>
                    <!--<a href="MiServlet1?menu=autores&accion=listar">Autores</a>-->
                    <form action="MiServlet1" method="post">
                        <input  type="hidden" name="accion" value="listar" >
                        <input type="submit" name="menu" value="Autores"/>
                    </form>
                </li>
                <li>Libros </li>
                <li>Editoriales</li>
            </ul>
        </nav>

    </body>
</html>
