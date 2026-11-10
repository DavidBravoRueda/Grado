package negocio;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private List<Usuario> usuarios;

    // Constructor
    public GestorUsuarios() {
        usuarios = new ArrayList<>();
    }

    // Método para agregar un usuario al gestor
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para eliminar un usuario del gestor
    public void eliminarUsuario(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarios.remove(i);
                break;
            }
        }
    }

    // Método para buscar un usuario por su ID
    public Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null; // Devolver null si no se encuentra el usuario
    }

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarios;
    }

    // Método para actualizar los datos de un usuario
    public void actualizarUsuario(Usuario usuarioActualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuarioActualizado.getId()) {
                usuarios.set(i, usuarioActualizado);
                break;
            }
        }
    }
}
