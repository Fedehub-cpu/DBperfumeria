package com.mycompany.dbperfumeria;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;


public class CRUD {
    
    BDConexion con2= new BDConexion();
    
    public void insertar(clientes a){
    
    try{
    
    //Establecemos conexión
    Connection conexion = con2.establecerConexion();
    
    //Creamos la consulta
    String sql = "INSERT INTO clientes" +
        " (id, nombre, apellidos, fecha_nacimiento, telefonos) VALUES " +
        " (?,?,?,?,?);";

    //Establecer los valores    
 PreparedStatement pstmt = conexion.prepareStatement(sql);
    
    Array arraysql = conexion.createArrayOf("varchar", a.getTelefonos());
    
  pstmt.setInt(1, a.getId());
  pstmt.setString(2, a.getNombre());
  pstmt.setString(3, a.getApellidos());
  pstmt.setDate(4, new java.sql.Date(a.getFecha_nacimiento().getTime()));
  pstmt.setArray(5, arraysql);
   
   int res = pstmt.executeUpdate();
   System.out.println(res);
   conexion.close();
   System.out.println("El registro se guardó correctamente");
    }
    catch(Exception e){
    
    JOptionPane.showMessageDialog(null,"El registro NO se guardó correctamente" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
    }
  }
    
    public void actualizar(int id, clientes a) throws SQLException{
     
       try{ 

    Connection conexion = con2.establecerConexion();
    
    String UPDATE_SQL= "UPDATE clientes "
               + "SET nombre = ?" 
               + "WHERE id = ?";

    PreparedStatement pstmt = conexion.prepareStatement(UPDATE_SQL);
   
    pstmt.setString(1, a.getNombre());
    pstmt.setInt(2, id);


   int res = pstmt.executeUpdate();
   System.out.println(res);
   conexion.close();
   
   System.out.println("El registro se actualizó correctamente");
       
       }
       catch(Exception e){
    
    JOptionPane.showMessageDialog(null,"El registro NO se actualizó correctamente" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public void delete(int id, clientes a) throws SQLException{
    
        try{
        Connection conexion = con2.establecerConexion();
    
        String DELETE_SQL = "DELETE FROM clientes WHERE id = ?";
        
        PreparedStatement pstmt = conexion.prepareStatement(DELETE_SQL);
   
        pstmt.setInt(1, id);
        
        int res = pstmt.executeUpdate();
        System.out.println(res);
        conexion.close();
        }
        catch(Exception e){
    
    JOptionPane.showMessageDialog(null,"El registro NO se eliminó correctamente" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public void read () throws SQLException{
    
        try{
        Connection conexion = con2.establecerConexion();
        
        String SELECT_SQL = "SELECT * FROM clientes";
        
     Statement st = conexion.createStatement();
     ResultSet resultado = st.executeQuery(SELECT_SQL);
    
    System.out.println("Contenido de la tabla");
    System.out.println("----------------------");
    while(resultado.next()){
        
        System.out.println(resultado.getInt("id")+ " ");
        System.out.println(resultado.getString("nombre")+ " ");
        System.out.println(resultado.getString("apellidos")+ " ");
        System.out.println(resultado.getString("fecha_nacimiento")+ " ");
        System.out.println(resultado.getString("telefonos")+ " ");
        
    }

        }
        catch(Exception e){
    JOptionPane.showMessageDialog(null,"El registro NO se ha leido correctamente" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
   }
  }
 }
    
    
    
    
    
         

