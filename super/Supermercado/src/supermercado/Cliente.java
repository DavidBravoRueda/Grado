package supermercado;

// Clase que representa a un cliente en el supermercado
public class Cliente {
	int id;
    String nombre;
    int numArticulos;

    public Cliente(int id, String nombre, int numArticulos) {
        this.id = id;
        this.nombre = nombre;
        this.numArticulos = numArticulos;
    }

    public String toString() {
        return nombre + " (" + numArticulos + " artículos)";
    }
}