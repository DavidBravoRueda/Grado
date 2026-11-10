package negocio;

import java.util.List;

public class ServicioUsuarios {
    private GestorUsuarios gestorUsuarios;

    public ServicioUsuarios(GestorUsuarios gestorUsuarios) {
        this.gestorUsuarios = gestorUsuarios;
    }

    // agregar un usuario
    public void agregarUsuario(Usuario usuario) {
        gestorUsuarios.agregarUsuario(usuario);
    }

    // eliminar un usuario
    public void eliminarUsuario(int id) {
        gestorUsuarios.eliminarUsuario(id);
    }

    // buscar un usuario por su ID
    public Usuario buscarUsuario(int id) {
        return gestorUsuarios.buscarUsuario(id);
    }

    // obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return gestorUsuarios.obtenerTodosLosUsuarios();
    }

    // actualizar los datos de un usuario
    public void actualizarUsuario(Usuario usuarioActualizado) {
        gestorUsuarios.actualizarUsuario(usuarioActualizado);
    }
}

