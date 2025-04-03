<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Editoriales" %>

<%
    Editoriales Editorial = (Editoriales) request.getAttribute("editorial");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Editorial</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-dark">
    <div class="container-sm w-25">
        <h1 class="text-light mt-5">Editar Editorial</h1>
        <form action="MiServlet1" method="post">
            <input type="hidden" name="id" value="<%=Editorial.getIdEditorial() %>">

            <label for="txt_nombre" class="form-label text-light mt-3">Nombre del Autor:</label>
            <input type="text" name="txt_nombre" id="txt_nombre" class="form-control"
                   value="<%=Editorial.getNombre()%>" required/>

            <label for="txt_pais" class="form-label text-light mt-3">País de Origen:</label>
            <select name="txt_pais" id="txt_pais" class="form-select">
                <option value="Colombia" <%=Editorial.getPais().equals("Colombia") ? "selected" : ""%>>Colombia</option>
                <option value="Estados Unidos" <%=Editorial.getPais().equals("Estados Unidos") ? "selected" : ""%>>Estados Unidos</option>
                <option value="España" <%=Editorial.getPais().equals("España") ? "selected" : ""%>>España</option>
                <option value="México" <%=Editorial.getPais().equals("México") ? "selected" : ""%>>México</option>
                <option value="Chile" <%=Editorial.getPais().equals("Chile") ? "selected" : ""%>>Chile</option>
                <option value="Argentina" <%=Editorial.getPais().equals("Argentina") ? "selected" : ""%>>Argentina</option>
                <option value="Brasil" <%=Editorial.getPais().equals("Brasil") ? "selected" : ""%>>Brasil</option>
                <option value="Ecuador" <%=Editorial.getPais().equals("Ecuador") ? "selected" : ""%>>Ecuador</option>
            </select>

            <input type="hidden" name="menu" value="Editorial">
            <input type="hidden" name="accion" value="Actualizar">

            <br>
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
            <a href="MiServlet1?menu=Editorial&accion=listar" class="btn btn-danger">Cancelar</a>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
