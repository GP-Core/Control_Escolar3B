/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author yadia
 */
public class AlumnoDAO {
    // Método para obtener grado_id por nombre
    
    Conexion c = new Conexion();
    public int obtenerGradoIdPorNombre(String nombreGrado) {
        String sql = "SELECT grado_id FROM grados WHERE grado_nombre = ?";
        try {
                Connection con = c.abrirConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nombreGrado);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("grado_id");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // no encontrado
    }

    // Método para obtener grupo_id por nombre
    public int obtenerGrupoIdPorNombre(String nombreGrupo) {
        String sql = "SELECT grupo_id FROM grupos WHERE grupo_nombre = ?";
        try (Connection con = c.abrirConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreGrupo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("grupo_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // no encontrado
    }

    // Método para insertar alumno
    public boolean insertarAlumno(String nombre, String apellidos, Date fechaNacimiento, String nombreGrado, String nombreGrupo, int sesionCreacion) {
        int gradoId = obtenerGradoIdPorNombre(nombreGrado);
        int grupoId = obtenerGrupoIdPorNombre(nombreGrupo);

        if (gradoId == -1 || grupoId == -1) {
            System.out.println("Grado o grupo no encontrados");
            return false;
        }

        String sql = "INSERT INTO alumnos (alu_nombre, alu_apellidos, fecha_nacimiento, grado_id, grupo_id, sesion_creacion) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = c.abrirConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setDate(3, new java.sql.Date(fechaNacimiento.getTime()));
            ps.setInt(4, gradoId);
            ps.setInt(5, grupoId);
            ps.setInt(6, sesionCreacion);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
