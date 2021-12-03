/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Alumnos;
import modelo.AlumnosDAO;

/**
 *
 * @author julian
 */
@WebServlet(name = "alumnocontroller", urlPatterns = {"/alumnocontroller"})
public class alumnocontroller extends HttpServlet {

    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
       AlumnosDAO alumnosdao=new AlumnosDAO();
        String accion;
        RequestDispatcher dispacher=null;
        accion=request.getParameter("accion");
        
        if(accion==null||accion.isEmpty())
        {
            dispacher=request.getRequestDispatcher("Vistas/alumnos.jsp");            
        }
        else if(accion.equals("modificar"))
        {
            dispacher=request.getRequestDispatcher("Vistas/modificar.jsp");
        }
        else if (accion.equals("actualizar"))
        {
        int id=Integer.parseInt(request.getParameter("id"));    
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String mail=request.getParameter("mail");    
        Alumnos alumno=new Alumnos(id,nombre,apellido,mail);
        alumnosdao.actualizarAlumno(alumno);
        dispacher=request.getRequestDispatcher("Vistas/alumnos.jsp");
        }
        else if(accion.equals("eliminar"))
        {
          int id=Integer.parseInt(request.getParameter("id")) ;
          alumnosdao.eliminarAlumno(id);
          dispacher=request.getRequestDispatcher("Vistas/alumnos.jsp"); 
        }
        
        
        else if(accion.equals("nuevo"))
        {
            dispacher=request.getRequestDispatcher("Vistas/nuevo.jsp"); 
        } 
        else if(accion.equals("insert"))
        {
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String mail=request.getParameter("mail");            
            Alumnos alumno=new Alumnos(0,nombre,apellido,mail);
            alumnosdao.insertarAlumnos(alumno);            
            dispacher=request.getRequestDispatcher("Vistas/alumnos.jsp"); 
        }
        else
        {
            dispacher=request.getRequestDispatcher("Vistas/alumnos.jsp");
        }
        
        dispacher.forward(request,response);   
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        doGet(request,response);
    }

    
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }

}
