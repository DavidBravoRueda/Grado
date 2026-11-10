package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contacto {

    private SimpleStringProperty nombre;
    private SimpleStringProperty telefono;
    private SimpleStringProperty email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = new SimpleStringProperty(nombre);
        this.telefono = new SimpleStringProperty(telefono);
        this.email = new SimpleStringProperty(email);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty telefonoProperty() {
        return telefono;
    }

    public StringProperty emailProperty() {
        return email;
    }
}