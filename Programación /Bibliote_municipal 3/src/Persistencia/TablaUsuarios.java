package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TablaUsuarios {
    private static final String URL = "jdbc:mysql://localhost/consultas";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "david1287";

    // Método para crear la tabla usuarios en la base de datos
    public static void crearTabla() {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             Statement statement = conexion.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(255) NOT NULL," +
                    "apellido VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "contrasena VARCHAR(255) NOT NULL," +
                    "es_admin BOOLEAN NOT NULL)";
            statement.executeUpdate(sql);
            System.out.println("Tabla usuarios creada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla usuarios: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        crearTabla();
    }
}

