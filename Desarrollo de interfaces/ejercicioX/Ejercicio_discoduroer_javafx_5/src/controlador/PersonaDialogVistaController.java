/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Persona;

/**
 * FXML Controller class
 *
 * @author davidbravorueda
 */
public class PersonaDialogVistaController implements Initializable {
    
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnSalir;

    private Persona persona;

    private ObservableList<Persona> personas;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initAttributtes(ObservableList<Persona> personas) {
        this.personas = personas;
    }
    
    @FXML
    private void guardar(ActionEvent event) {

        String nombre = this.txtNombre.getText();
        String apellidos = this.txtApellidos.getText();
        int edad = Integer.parseInt(this.txtEdad.getText());

        Persona p = new Persona(nombre, apellidos, edad);

        if (!personas.contains(p)) {
            this.persona = p;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Se ha añadido correctamente");
            alert.showAndWait();

            Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }

    }

    @FXML
    private void salir(ActionEvent event) {
        this.persona = null;
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();

    }

    public Persona getPersona() {
        return persona;
    }
    
}
