package controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import modelo.Contacto;

public class ControladorContactos {

    @FXML
    private TableView<Contacto> tablaContactos;
    @FXML
    private TableColumn<Contacto, String> columnaNombre;
    @FXML
    private TableColumn<Contacto, String> columnaTelefono;
    @FXML
    private TableColumn<Contacto, String> columnaEmail;
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoTelefono;
    @FXML
    private TextField campoEmail;

    private ObservableList<Contacto> listaContactos = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Inicializar la tabla y las columnas
        tablaContactos.setItems(listaContactos);
        columnaNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        columnaTelefono.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
        columnaEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
    }

    @FXML
    private void agregarContacto() {
        // Obtener datos de los campos
        String nombre = campoNombre.getText();
        String telefono = campoTelefono.getText();
        String email = campoEmail.getText();

        // Limpiar los campos
        campoNombre.clear();
        campoTelefono.clear();
        campoEmail.clear();

        // Crear nuevo contacto y agregarlo a la lista
        Contacto nuevoContacto = new Contacto(nombre, telefono, email);
        listaContactos.add(nuevoContacto);
    }
}