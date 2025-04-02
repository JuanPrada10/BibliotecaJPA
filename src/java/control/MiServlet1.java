/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

/**
 *
 * @author Estudiante
 */
public class MiServlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
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
                        System.out.println("lista: " + lista_a);
                        request.setAttribute("lista_autor", lista_a);

                        request.getRequestDispatcher("g_autor.jsp").forward(request, response);
                        break;
                    }
                    case "Nuevo": {
                        request.getRequestDispatcher("nuevo_a.jsp").forward(request, response);
                        break;

                    }
                    case "Registrar": {
                        System.out.println("ingreso a registrar");
                        String nombre = request.getParameter("txt_nombre");
                        String pais = request.getParameter("txt_pais");
                        Autores dto = new Autores(nombre, pais);
                        AutoresJpaController jpa = new AutoresJpaController();
                        jpa.create(dto);
                        System.out.println("paso de crear");
                        request.getRequestDispatcher("MiServlet1?menu=Autores&accion=listar").forward(request,
                                response);
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
                            request.getRequestDispatcher("MiServlet1?menu=Autores&accion=listar").forward(request,
                                    response);

                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(MiServlet1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;

                    }

                    case "buscar": {
                        break;

                    }
                    default: {
                        System.out.println("accion disponible");
                        break;

                    }
                }

            }
            default: {
                System.out.println("menu no disponible");
                break;

            }

        }

        // response.setContentType("text/html;charset=UTF-8");
        // try (PrintWriter out = response.getWriter()) {
        // /* TODO output your page here. You may use following sample code. */
        // out.println("<!DOCTYPE html>");
        // out.println("<html>");
        // out.println("<head>");
        // out.println("<title>Servlet MiServlet1</title>");
        // out.println("</head>");
        // out.println("<body>");
        // out.println("<h1>Servlet MiServlet1 at " + request.getContextPath() +
        // "</h1>");
        // out.println("</body>");
        // out.println("</html>");
        // }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
