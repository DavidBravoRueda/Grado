/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Vehiculo;

/**
 * FXML Controller class
 *
 * @author davidbravorueda
 */
public class InsertarServiciosController implements Initializable {

    @FXML
    private Button btnGrabar;
    @FXML
    private ComboBox<Cliente> cmbClientes;
    @FXML
    private ComboBox<Vehiculo> cmbVehiculos;
    @FXML
    private TextField txtDirCli;
    @FXML
    private TextField txtNIFCli;
    @FXML
    private TextField txtPrecioVeh;
    @FXML
    private TextField txtKmVeh;
    @FXML
    private TextField txtMarcaVeh;
    @FXML
    private TextField txtDescripcionVeh;
    @FXML
    private TextField txtPobCli;
    @FXML
    private DatePicker dtpFechaAlquiler;
    @FXML
    private DatePicker dtpFechaEntrega;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initCombos();
    }  
    
    public void initCombos() {

        Cliente c = new Cliente();
        ObservableList<Cliente> obsClientes = c.getClientes();
        this.cmbClientes.setItems(obsClientes);

        Vehiculo v = new Vehiculo();
        ObservableList<Vehiculo> obsVehiculos = v.getVehiculos();
        this.cmbVehiculos.setItems(obsVehiculos);

    }

    public void closeWindows() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuVista.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnGrabar.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
