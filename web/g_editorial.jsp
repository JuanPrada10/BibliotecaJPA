<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Editoriales" %>
<%
List<Editoriales> lta =(List<Editoriales>) request.getAttribute("lista_editorial");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestión de Editoriales</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-dark">
    <div class="container-sm">
    <h1 class="text-light mt-4 mb-4">Lista de Editoriales</h1>
    <table class="table table-dark table-hover  w-30">
        <tr class="text-center">
            <th>ID</th>
            <th>Nombre</th>
            <th>Pais</th>
            <th>Acciones</th>
        </tr>
        <%
            List<Editoriales> lista = (List<Editoriales>) request.getAttribute("lista_editorial");
            if (lista != null) {
                for (Editoriales dto : lista) {
        %>
        <tr class="text-center">
            <td><%= dto.getIdEditorial() %></td>
            <td><%= dto.getNombre() %></td>
            <td><%= dto.getPais() %></td>
            <td>
                <a class="btn btn-success" href="MiServlet1?menu=Editorial&accion=editar&id=<%= dto.getIdEditorial() %>">Editar</a> 
                <a class="btn btn-danger" href="MiServlet1?menu=Editorial&accion=eliminar&id_e=<%= dto.getIdEditorial() %>">Eliminar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    </table>
                <form action="MiServlet1" method="post">
                    <input type="hidden" name="menu" value="Editorial">
                    <input type="submit" name="accion" value="Nuevo" class="btn btn-primary">
                </form>  
     </div>
</body>
</html>
