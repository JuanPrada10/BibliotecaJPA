<%-- 
    Document   : nuevo_a
    Created on : 1/04/2025, 8:27:36 a. m.
    Author     : Estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Nuevo Autor</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>
        <div class="container-fluid">
            <h1>Nuevo Autor</h1>
            <form action="MiServlet1" method="post">
                <label for="txt_nombre" class="form-label">Nombre del Autor:</label>
                <input type="text" name="txt_nombre" id="txt_nombre" class="form-control" 
                       pattern="[a-zA-Z\s]+" title="Solo se permiten letras y espacios" required/>
                <label for="txt_pais" class="form-label">País de Origen:</label>
                <select name="txt_pais" id="txt_pais" class="form-select">
                    <option value="Colombia">Colombia</option>
                    <option value="Perú">Perú</option>
                    <option value="Venezuela">Venezuela</option>
                    <option value="México">México</option>
                    <option value="Chile">Chile</option>
                    <option value="Argentina">Argentina</option>
                    <option value="Brasil">Brasil</option>
                    <option value="Ecuador">Ecuador</option>
                </select>
                <input type="hidden" name="menu" value="Autores">
                <input type="submit" name="accion" class="btn btn-primary mb-3" value="Registrar">
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

    </body>
</html>
