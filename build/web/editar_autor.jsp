<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Autores" %>

<%
    Autores autor = (Autores) request.getAttribute("autor");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Autor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-dark">
    <div class="container-sm w-25">
        <h1 class="text-light mt-5">Editar Autor</h1>
        <form action="MiServlet1" method="post">
            <input type="hidden" name="id" value="<%=autor.getIdAutor()%>">

            <label for="txt_nombre" class="form-label text-light mt-3">Nombre del Autor:</label>
            <input type="text" name="txt_nombre" id="txt_nombre" class="form-control"
                   value="<%=autor.getNombre()%>" required/>

            <label for="txt_pais" class="form-label text-light mt-3">País de Origen:</label>
            <select name="txt_pais" id="txt_pais" class="form-select">
                <option value="Colombia" <%=autor.getPais().equals("Colombia") ? "selected" : ""%>>Colombia</option>
                <option value="Perú" <%=autor.getPais().equals("Perú") ? "selected" : ""%>>Perú</option>
                <option value="Venezuela" <%=autor.getPais().equals("Venezuela") ? "selected" : ""%>>Venezuela</option>
                <option value="México" <%=autor.getPais().equals("México") ? "selected" : ""%>>México</option>
                <option value="Chile" <%=autor.getPais().equals("Chile") ? "selected" : ""%>>Chile</option>
                <option value="Argentina" <%=autor.getPais().equals("Argentina") ? "selected" : ""%>>Argentina</option>
                <option value="Brasil" <%=autor.getPais().equals("Brasil") ? "selected" : ""%>>Brasil</option>
                <option value="Ecuador" <%=autor.getPais().equals("Ecuador") ? "selected" : ""%>>Ecuador</option>
            </select>

            <input type="hidden" name="menu" value="Autores">
            <input type="hidden" name="accion" value="Actualizar">

            <br>
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
            <a href="MiServlet1?menu=Autores&accion=listar" class="btn btn-danger">Cancelar</a>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
