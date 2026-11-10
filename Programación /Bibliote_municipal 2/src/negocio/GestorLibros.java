package negocio;

import java.util.ArrayList;
import java.util.List;

public class GestorLibros {
    private List<Libro> libros;

    // Constructor
    public GestorLibros() {
        libros = new ArrayList<>();
    }

    // Método para agregar un libro al gestor
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Método para eliminar un libro del gestor
    public void eliminarLibro(int id) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == id) {
                libros.remove(i);
                break;
            }
        }
    }

    // Método para buscar un libro por su ID
    public Libro buscarLibro(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null; // Devolver null si no se encuentra el libro
    }

    // Método para obtener todos los libros
    public List<Libro> obtenerTodosLosLibros() {
        return libros;
    }

    // Método para actualizar los datos de un libro
    public void actualizarLibro(Libro libroActualizado) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libroActualizado.getId()) {
                libros.set(i, libroActualizado);
                break;
            }
        }
    }
}

