<%-- 
    Document   : alumnos
    Created on : 2 dic. 2021, 14:48:46
    Author     : julian
--%>

<%@page import="modelo.AlumnosDAO"%>
<%@page import="modelo.Alumnos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"><!-- comment -->
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
   
    
    </head>
    <body>
        <h1>Listado de Alumnos</h1>
       
          
        
        
        <div class="container">
            <div class="row">
                <a class="btn btn-primary col-4 m-4" href="alumnocontroller?accion=nuevo">Agregar Alumno</a>
                <table class="table table-primary" >
                    <thead>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Email</th>
                        <th>Modificar</th>
                        <th>Eliminar</th>
                    </thead>                   
                <%
                 List<Alumnos> resultado=null;
                 AlumnosDAO alumno=new AlumnosDAO();
                 resultado=alumno.listarAlumnos();     
                    for(int i=0;i<resultado.size();i++)
                    {
                    String ruta="alumnocontroller?accion=modificar&id="+resultado.get(i).getId();
                    String rutaE="alumnocontroller?accion=eliminar&id="+resultado.get(i).getId();
                %> 
                <tr>
                    <td><%=resultado.get(i).getId() %></td>
                    <td><%=resultado.get(i).getNombre() %></td>
                    <td><%=resultado.get(i).getApellido() %></td>
                    <td><%=resultado.get(i).getMail() %></td>
                    <td><a class="text-success" href=<%=ruta %>>X</a></td>
                    <td><a class="text-danger" href=<%=rutaE %>>X</a></td>                    
                </tr>         
                 <%
                     }
                 %> 
                </table>          
            </div>     
        </div>
        
        
        
        
        
        
        
        
        
    
    </body>
</html>
