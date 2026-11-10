package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TablaLibros {
    private static final String URL = "jdbc:mysql://localhost/consultas";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "david1287";

    // Método para crear la tabla libros en la base de datos
    public static void crearTabla() {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             Statement statement = conexion.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS libros (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "titulo VARCHAR(255) NOT NULL," +
                    "autor VARCHAR(255) NOT NULL," +
                    "categoria VARCHAR(255)," +
                    "paginas INT," +
                    "disponible BOOLEAN NOT NULL)";
            statement.executeUpdate(sql);
            System.out.println("Tabla libros creada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla libros: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        crearTabla();
    }
}

