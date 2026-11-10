package Persistencia;

import negocio.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarUsuario(Usuario usuario) throws SQLException {
        String consulta = "INSERT INTO usuarios (nombre, apellido, email, contrasena, es_admin) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getContrasena());
            statement.setBoolean(5, usuario.isEsAdmin());
            statement.executeUpdate();
        }
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String consulta = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getEmail());
            statement.setInt(4, usuario.getId());
            statement.executeUpdate();
        }
    }

    public void eliminarUsuario(int id) throws SQLException {
        String consulta = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        String consulta = "SELECT * FROM usuarios WHERE email = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("contrasena"),
                    rs.getBoolean("es_admin")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Usuario> obtenerTodosLosUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String consulta = "SELECT * FROM usuarios";
        try (Statement statement = conexion.createStatement()) {
            ResultSet rs = statement.executeQuery(consulta);
            while (rs.next()) {
                usuarios.add(new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("contrasena"),
                    rs.getBoolean("es_admin")
                ));
            }
        }
        return usuarios;
    }
}



