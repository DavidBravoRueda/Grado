package Ej2;

import java.util.Comparator;

public class Futbolista implements Comparable<Futbolista> {
    private String dni;
    private String nombre;
    private int edad;
    private int numeroGoles;

    public Futbolista(String dni, String nombre, int edad, int numeroGoles) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.numeroGoles = numeroGoles;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", numeroGoles=" + numeroGoles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Futbolista that = (Futbolista) o;
        return dni.equals(that.dni);
    }

    @Override
    public int compareTo(Futbolista otro) {
        return this.dni.compareTo(otro.dni);
    }

    public static final Comparator<Futbolista> COMPARADOR_NOMBRE = Comparator.comparing(Futbolista::getNombre);

    public static final Comparator<Futbolista> COMPARADOR_EDAD = Comparator.comparingInt(Futbolista::getEdad);

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}