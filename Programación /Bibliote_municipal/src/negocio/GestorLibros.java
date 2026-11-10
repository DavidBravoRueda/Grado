package negocio;

import java.util.ArrayList;
import java.util.List;

public class GestorLibros {
    private List<Libro> libros;

    public GestorLibros() {
        libros = new ArrayList<>();
    }

    // agregar un libro al gestor
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // eliminar un libro del gestor
    public void eliminarLibro(int id) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == id) {
                libros.remove(i);
                break;
            }
        }
       
    }
    
    public 

    // buscar un libro por su ID
    public Libro buscarLibro(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null; 
    }

    // obtener todos los libros
    public List<Libro> obtenerTodosLosLibros() {
        return libros;
    }

    // actualizar los datos de un libro
    public void actualizarLibro(Libro libroActualizado) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libroActualizado.getId()) {
                libros.set(i, libroActualizado);
                break;
            }
        }
    }
}

