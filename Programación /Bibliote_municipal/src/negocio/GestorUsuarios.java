package negocio;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private List<Usuario> usuarios;

    
    public GestorUsuarios() {
        usuarios = new ArrayList<>();
    }

    // agregar un usuario al gestor
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // eliminar un usuario del gestor
    public void eliminarUsuario(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarios.remove(i);
                break;
            }
        }
    }

    // buscar un usuario por su ID
    public Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null; 
    }

    // obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarios;
    }

    // actualizar los datos de un usuario
    public void actualizarUsuario(Usuario usuarioActualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuarioActualizado.getId()) {
                usuarios.set(i, usuarioActualizado);
                break;
            }
        }
    }
}
