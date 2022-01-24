package com.mycompany.dbperfumeria;

import java.sql.*;
import javax.swing.JOptionPane;

public class BDConexion {
    
    Connection conectar = null;
    
    String usuario = "postgres";
    String contraseña = "root";
    String bd = "Perfumeria";
    String ip = "localhost";
    String puerto = "5432";
    
    String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
   public Connection establecerConexion(){
   
   try{
        Class.forName("org.postgresql.Driver");
        conectar = DriverManager.getConnection(cadena,usuario,contraseña);
   System.out.println("Se ha conectado correctamente a la base de datos");
   
   }catch(Exception e){
       
       JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
       
       ;}
        return conectar;
        
   }  
}
