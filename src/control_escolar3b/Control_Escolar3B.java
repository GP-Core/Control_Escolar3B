/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control_escolar3b;

import Conexion.Conexion;

/**
 *
 * @author fabia
 */
public class Control_Escolar3B {

    /**
     * @param args the command line arguments
     */
    static Conexion conex ;
    public static void main(String[] args) {
        // TODO code application logic here
        conex = new Conexion();
        conex.abrirConexion();
    }
    
}
