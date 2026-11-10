package Persistencia;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import negocio.Prestamo;

public class PrestamoDAO {
    private Connection conexion;

    public PrestamoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean usuarioExiste(String nombreUsuario) throws SQLException {
        String consulta = "SELECT id FROM usuarios WHERE nombre = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, nombreUsuario);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    public void registrarPrestamo(Prestamo prestamo) throws SQLException {
        // Verificar si el usuario existe
        if (!usuarioExiste(prestamo.getNombreUsuario())) {
            throw new SQLException("El usuario '" + prestamo.getNombreUsuario() + "' no existe.");
        }

        String consulta = "INSERT INTO prestamos (nombre_libro, nombre_usuario, fecha_hora_prestamo) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, prestamo.getNombreLibro());
            statement.setString(2, prestamo.getNombreUsuario());
            statement.setTimestamp(3, Timestamp.valueOf(prestamo.getFechaHoraPrestamo()));
            statement.executeUpdate();
        }
    }

    // Método para eliminar un préstamo
    public void eliminarPrestamo(Prestamo prestamo) throws SQLException {
        String consulta = "DELETE FROM prestamos WHERE nombre_libro = ? AND nombre_usuario = ? AND fecha_hora_prestamo = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, prestamo.getNombreLibro());
            statement.setString(2, prestamo.getNombreUsuario());
            statement.setTimestamp(3, Timestamp.valueOf(prestamo.getFechaHoraPrestamo()));
            statement.executeUpdate();
        }
    }

    // Método para obtener todos los préstamos
    public List<Prestamo> obtenerTodosLosPrestamos() throws SQLException {
        List<Prestamo> prestamos = new ArrayList<>();
        String consulta = "SELECT nombre_libro, nombre_usuario, fecha_hora_prestamo FROM prestamos";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {
            while (resultSet.next()) {
                String nombreLibro = resultSet.getString("nombre_libro");
                String nombreUsuario = resultSet.getString("nombre_usuario");
                LocalDateTime fechaHoraPrestamo = resultSet.getTimestamp("fecha_hora_prestamo").toLocalDateTime();
                prestamos.add(new Prestamo(nombreLibro, nombreUsuario, fechaHoraPrestamo));
            }
        }
        return prestamos;
    }
}
