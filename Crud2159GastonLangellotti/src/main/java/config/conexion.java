/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.net.ConnectException;
import java.sql.*;

/**
 *
 * @author julian
 */
public class conexion 
{
    public String driver="org.mariadb.jdbc.Driver";
    
    
    public Connection getConnection()
    {
        Connection conexion=null;
        try
        {
            Class.forName(driver);
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud2159gastonlangellotti","root","");
        }
        catch(ClassNotFoundException|SQLException e)
        {
                    System.out.println(e);
        }
        return conexion;    
    }   

    
public static void main(String [] args) throws SQLException
{
    Connection conexion=null;
    conexion con=new conexion();
    conexion =con.getConnection();
    
    PreparedStatement ps;
    ResultSet rs;
    
    ps=conexion.prepareStatement("SELECT * FROM alumnos");
    rs=ps.executeQuery();
    
    while(rs.next())
    {
     int id=rs.getInt("id");
     String nombre=rs.getString("nombre");
     String apellido=rs.getString("apellido");
     String mail=rs.getString("mail");     
     System.out.println("id:"+id+" Nombre:"+nombre+" Apellido:"+apellido+" Mail:"+mail);
    }   
}
}


