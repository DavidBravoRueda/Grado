package Paquete1;

//En esta clse añadimos propiedades a los inmuebles
public class Propiedad {
	private String id;
	private String tipo;
	private int habitaciones;
	private String poblacion;
	
	//constructor
	public Propiedad(String id, String tipo, int habitaciones, String poblacion) {
		this.id = id;
		this.tipo = tipo;
		this.habitaciones = habitaciones;
		this.poblacion = poblacion;
	}

	//Getters y setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	//Método toString para una representacion en cadena del objeto
	@Override
    public String toString() {
        return "Propiedad{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                ", habitaciones=" + habitaciones +
                ", poblacion='" + poblacion + '\'' +
                '}';
    }
	
}
