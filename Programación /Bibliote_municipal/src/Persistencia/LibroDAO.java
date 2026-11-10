package Persistencia;

import negocio.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {
    private Connection conexion;

    public LibroDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // agregar un libro
    public void agregarLibro(Libro libro) throws SQLException {
        String consulta = "INSERT INTO libros (titulo, autor, categoria, disponible) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setString(3, libro.getCategoria());
            statement.setBoolean(4, libro.isDisponible());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);
                libro.setId(idGenerado);
            } else {
                throw new SQLException("No se pudo obtener el ID generado para el libro.");
            }
        }
    }

    // modificar un libro
    public void modificarLibro(Libro libro) throws SQLException {
        String consulta = "UPDATE libros SET titulo = ?, autor = ?, categoria = ?, disponible = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setString(3, libro.getCategoria());
            statement.setBoolean(4, libro.isDisponible());
            statement.setInt(5, libro.getId());
            statement.executeUpdate();
        }
    }

    // eliminar un libro por su ID
    public void eliminarLibro(int id) throws SQLException {
        String consulta = "DELETE FROM libros WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // buscar un libro por su ID
    public Libro buscarLibroPorId(int id) throws SQLException {
        String consulta = "SELECT titulo, autor, categoria, disponible FROM libros WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String titulo = resultSet.getString("titulo");
                    String autor = resultSet.getString("autor");
                    String categoria = resultSet.getString("categoria");
                    boolean disponible = resultSet.getBoolean("disponible");
                    return new Libro(id, titulo, autor, categoria, disponible);
                }
            }
        }
        return null;
    }

    // obtener todos los libros
    public List<Libro> obtenerTodosLosLibros() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String consulta = "SELECT id, titulo, autor, categoria, disponible FROM libros";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                String categoria = resultSet.getString("categoria");
                boolean disponible = resultSet.getBoolean("disponible");
                libros.add(new Libro(id, titulo, autor, categoria, disponible));
            }
        }
        return libros;
    }

    // buscar libros por título (parcial)
    public List<Libro> buscarLibrosPorTitulo(String titulo) throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String consulta = "SELECT id, titulo, autor, categoria, disponible FROM libros WHERE titulo LIKE ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, "%" + titulo + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String tituloLibro = resultSet.getString("titulo");
                    String autor = resultSet.getString("autor");
                    String categoria = resultSet.getString("categoria");
                    boolean disponible = resultSet.getBoolean("disponible");
                    libros.add(new Libro(id, tituloLibro, autor, categoria, disponible));
                }
            }
        }
        return libros;
    }
}





