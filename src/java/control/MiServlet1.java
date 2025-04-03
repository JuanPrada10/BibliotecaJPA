package control;

import control.exceptions.NonexistentEntityException;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Autores;
import modelo.Editoriales;

public class MiServlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        switch (menu) {
            case "Autores": {
                switch (accion) {
                    case "listar": {
                        AutoresJpaController jpa = new AutoresJpaController();
                        List<Autores> lista_a = jpa.findAutoresEntities();
                        request.setAttribute("lista_autor", lista_a);
                        request.getRequestDispatcher("g_autor.jsp").forward(request, response);
                        break;
                    }
                    case "Nuevo": {
                        request.getRequestDispatcher("nuevo_a.jsp").forward(request, response);
                        break;
                    }
                    case "Registrar": {
                        String nombre = request.getParameter("txt_nombre");
                        String pais = request.getParameter("txt_pais");
                        Autores dto = new Autores(nombre, pais);
                        AutoresJpaController jpa = new AutoresJpaController();
                        jpa.create(dto);
                        response.sendRedirect("MiServlet1?menu=Autores&accion=listar");
                        break;
                    }
                    case "editar": {
                        int id = Integer.parseInt(request.getParameter("id"));
                        AutoresJpaController jpa = new AutoresJpaController();
                        Autores autor = jpa.findAutores(id);
                        request.setAttribute("autor", autor);
                        request.getRequestDispatcher("editar_autor.jsp").forward(request, response);
                        break;
                    }
                    case "Actualizar": {
                        int id = Integer.parseInt(request.getParameter("id"));
                        String nombre = request.getParameter("txt_nombre");
                        String pais = request.getParameter("txt_pais");
                        try {
                            AutoresJpaController jpa = new AutoresJpaController();
                            Autores autor = jpa.findAutores(id);
                            autor.setNombre(nombre);
                            autor.setPais(pais);
                            jpa.edit(autor);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        response.sendRedirect("MiServlet1?menu=Autores&accion=listar");
                        break;
                    }
                    case "eliminar": {
                        try {
                            AutoresJpaController jpa = new AutoresJpaController();
                            int id_e = Integer.parseInt(request.getParameter("id_e"));
                            jpa.destroy(id_e);
                            response.sendRedirect("MiServlet1?menu=Autores&accion=listar");
                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(MiServlet1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                }
                break;
            }
            
            case "Editorial": {
                switch (accion) {
                    case "listar": {
                        EditorialesJpaController jpa = new EditorialesJpaController();
                        List<Editoriales> lista_e = jpa.findEditorialesEntities();
                        request.setAttribute("lista_editorial", lista_e);
                        request.getRequestDispatcher("g_editorial.jsp").forward(request, response);
                        break;
                    }
                    case "Nuevo": {
                        request.getRequestDispatcher("nuevo_e.jsp").forward(request, response);
                        break;
                    }
                    case "Registrar": {
                        String nombre = request.getParameter("txt_nombre");
                        String pais = request.getParameter("txt_pais");
                        Editoriales dto = new Editoriales(nombre,pais);
                        EditorialesJpaController jpa = new EditorialesJpaController();
                        jpa.create(dto);
                        response.sendRedirect("MiServlet1?menu=Editorial&accion=listar");
                        break;
                    }
                    case "editar": {
                        int id = Integer.parseInt(request.getParameter("id"));
                        EditorialesJpaController jpa = new EditorialesJpaController();
                        Editoriales editorial = jpa.findEditoriales(id);
                        request.setAttribute("editorial", editorial);
                        request.getRequestDispatcher("editar_editorial.jsp").forward(request, response);
                        break;
                    }
                    case "Actualizar": {
                        int id = Integer.parseInt(request.getParameter("id"));
                        String nombre = request.getParameter("txt_nombre");
                        String pais = request.getParameter("txt_pais");
                        try {
                            EditorialesJpaController jpa = new EditorialesJpaController();
                            Editoriales editorial = jpa.findEditoriales(id);
                            editorial.setNombre(nombre);
                            editorial.setPais(pais);
                            jpa.edit(editorial);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        response.sendRedirect("MiServlet1?menu=Editorial&accion=listar");
                        break;
                    }
                    case "eliminar": {
                        try {
                            EditorialesJpaController jpa = new EditorialesJpaController();
                            int id_e = Integer.parseInt(request.getParameter("id_e"));
                            jpa.destroy(id_e);
                            response.sendRedirect("MiServlet1?menu=Editorial&accion=listar");
                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(MiServlet1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                }
                break;
            }
            
            default: {
                System.out.println("Menú no disponible");
                break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}