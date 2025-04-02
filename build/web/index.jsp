<%-- Document : index Created on : 25/03/2025, 9:10:56 a. m. Author : Estudiante
--%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>Principal</title>
  </head>
  <body class="bg-dark">
    <div class="container-fluid bg-dark  ">
      
      <nav class="navbar navbar-expand-lg bg-dark ">
        <div class="container-fluid ">

         <a class="navbar-brand text-light fs-3 " href="#">BIBLIOTECA</a>
          
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 text-light">
              <li class="nav-item">
                <form action="MiServlet1" method="post">
                    <input type="hidden" name="accion" value="listar" />
                    <input type="hidden" name="menu" value="Autores" />
                    <button class="btn btn-dark fw-bold" type="submit"> Autores</button>
                  </form>
              </li>
              <li class="nav-item ">
                <button class="btn btn-dark fw-bold" type="submit"> Libros</button>
              </li>
              <li class="nav-item">
                <button class="btn btn-dark fw-bold" type="submit"> Editorial</button>
              </li>
            </ul>
            
          </div>
        </div>
      </nav>
    </div>
  </body>
</html>


