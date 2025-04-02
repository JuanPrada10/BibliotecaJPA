<%-- 
    Document   : g_autor
    Created on : 27/03/2025, 1:13:21 p. m.
    Author     : Estudiante
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Autores,java.util.List" %>
<%
List<Autores> lta =(List<Autores>) request.getAttribute("lista_autor");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Autores</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>
        <div class="container-fluid">
            <h1>Gestionar Autores</h1>
            <table class="table table-dark table-hover">
                <thead>
                    <tr>
                        <th>Id Autor</th>
                        <th>Nombre</th>
                        <th>Pais</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%for(Autores dto : lta){%>   
                    <tr>
                        <td><%=dto.getIdAutor()%></td>
                        <td><%=dto.getNombre()%></td>
                        <td><%=dto.getPais()%></td>
                        <td><a class="btn btn-danger"
                               href="MiServlet1?menu=Autores&accion=eliminar&id_e=<%=dto.getIdAutor()%>">Eliminar</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                <form action="MiServlet1" method="post">
                    <input type="hidden" name="menu" value="Autores">
                    <input type="submit" name="accion" value="Nuevo" class="btn btn-primary">
                </form>    
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
