/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubimusic.Conexion;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
   String bd="ubimusic";
   String url="jdbc:mysql://localhost:3306/";
   String user="root";
   String password="root";
   String driver="com.mysql.cj.jdbc.Driver";
   Connection conn;

    public Conexion() {
    }
   
   public Connection conectar(){
       try {
           Class.forName(driver);
           conn=DriverManager.getConnection(url+bd, user, password);
           System.out.println("CONEXION CON EXITO " + bd);
       } catch (ClassNotFoundException | SQLException ex) {
          System.out.println("ERROR EN LA CONEXION");
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           
       }
       return conn;
   }
   
   public void desconectar(){
       try {
           conn.close();
       } catch (SQLException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
