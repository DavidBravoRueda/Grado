package negocio;

import java.util.List;

public class ServicioLibros {
    private GestorLibros gestorLibros;

    public ServicioLibros(GestorLibros gestorLibros) {
        this.gestorLibros = gestorLibros;
    }

    // agregar un libro
    public void agregarLibro(Libro libro) {
        gestorLibros.agregarLibro(libro);
    }

    // eliminar un libro
    public void eliminarLibro(int id) {
        gestorLibros.eliminarLibro(id);
    }

    // buscar un libro por su ID
    public Libro buscarLibro(int id) {
        return gestorLibros.buscarLibro(id);
    }

    // obtener todos los libros
    public List<Libro> obtenerTodosLosLibros() {
        return gestorLibros.obtenerTodosLosLibros();
    }

    // actualizar los datos de un libro
    public void actualizarLibro(Libro libroActualizado) {
        gestorLibros.actualizarLibro(libroActualizado);
    }
    public void gestionarlibto() {
    	
    }
}
