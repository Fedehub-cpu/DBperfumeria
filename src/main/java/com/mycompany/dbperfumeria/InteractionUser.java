package com.mycompany.dbperfumeria;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class InteractionUser {
   
    static void interaccion() throws SQLException, ParseException{
    
    //Conexión con la base de datos
    //BDConexion conectar = new BDConexion();
    //conectar.establecerConexion();
    
    var crud = new CRUD();
    clientes a = new clientes();
    
    //Inserte un cliente
    
    a.setId(1);
    a.setNombre("Paco");
    a.setApellidos("Cuadra Torres");
    
    Date d = new SimpleDateFormat("MM-dd-yy").parse("02-14-98");    
    a.setFecha_nacimiento(d);
    String telephoneNumbers [] = {" 2138123 ", " 213123123 "};
    a.setTelefonos(telephoneNumbers);
    crud.insertar(a);
   
    //Utilice este método para actualizar el nombre del cliente introduciendo su id.
    
    a.setNombre("Paco");
    crud.actualizar(1, a);
      
   //Para eliminar una fila de la tabla introduzca la id del cliente.
    
    crud.delete(1, a);
      
   //Use este método para leer todos los campos de la tabla
   
    crud.read();
    
    }
}
