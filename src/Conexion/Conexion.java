/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author fabia
 */
public class Conexion {
    Connection conexion =  null;
    String walletLocation = "C:/Users/fabia/Desktop/4to Semestre/Ulloa_BD/proyecto/Wallet_ControlEscolarK"; // Ruta al wallet- depende de la locacion de la wallet
    String url = "jdbc:oracle:thin:@(description=(address_list=(address=(protocol=tcps)(host=adb.us-ashburn-1.oraclecloud.com)(port=1522)))(connect_data=(service_name=g552d137c17a67d_controlescolark_high.adb.oraclecloud.com)))";
    
    public Connection abrirConexion(){
        try {
            // Cargar el driver JDBC ...
            System.setProperty("oracle.net.wallet_location", walletLocation);
            conexion = DriverManager.getConnection(url, "Admin", "EquipoK_Los3brutales@");
            System.out.println("Conexión exitosa");
            System.out.println("Hola");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " +  e.getMessage());
            e.printStackTrace();
        }
        
        return conexion;
    }
    
}
