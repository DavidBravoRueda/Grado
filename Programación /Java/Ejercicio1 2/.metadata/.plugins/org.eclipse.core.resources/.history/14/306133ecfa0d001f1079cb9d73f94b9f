package negocio;

import java.util.List;

public class ServicioUsuarios {
    private GestorUsuarios gestorUsuarios;

    // Constructor
    public ServicioUsuarios(GestorUsuarios gestorUsuarios) {
        this.gestorUsuarios = gestorUsuarios;
    }

    // Método para agregar un usuario
    public void agregarUsuario(Usuario usuario) {
        gestorUsuarios.agregarUsuario(usuario);
    }

    // Método para eliminar un usuario
    public void eliminarUsuario(int id) {
        gestorUsuarios.eliminarUsuario(id);
    }

    // Método para buscar un usuario por su ID
    public Usuario buscarUsuario(int id) {
        return gestorUsuarios.buscarUsuario(id);
    }

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return gestorUsuarios.obtenerTodosLosUsuarios();
    }

    // Método para actualizar los datos de un usuario
    public void actualizarUsuario(Usuario usuarioActualizado) {
        gestorUsuarios.actualizarUsuario(usuarioActualizado);
    }
}

