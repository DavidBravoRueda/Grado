package Persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class PruebaConexion {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = ConexionBD.obtenerConexion();

            if (conexion != null && !conexion.isClosed()) {
                System.out.println("Conexión establecida correctamente.");
                String consulta = "SELECT * FROM usuarios LIMIT 1";
                try (Statement statement = conexion.createStatement();
                     ResultSet resultSet = statement.executeQuery(consulta)) {
                    if (resultSet.next()) {
                        System.out.println("Nombre del primer usuario: " + resultSet.getString("nombre"));
                    } else {
                        System.out.println("No se encontraron usuarios.");
                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión: " + e.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                    System.out.println("Conexión cerrada correctamente.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}
