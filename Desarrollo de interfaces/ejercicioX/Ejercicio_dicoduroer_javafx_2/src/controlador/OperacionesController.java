/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import modulo.Operaciones;

/**
 * FXML Controller class
 *
 * @author davidbravorueda
 */
public class OperacionesController implements Initializable {
    
    @FXML
    private javafx.scene.control.TextField txtOp1;
    @FXML
    private javafx.scene.control.TextField txtOp2;
    @FXML
    private javafx.scene.control.Button btnOperacion;
    @FXML
    private RadioButton rdbSuma;
    @FXML
    private RadioButton rdbResta;
    @FXML
    private RadioButton rdbMult;
    @FXML
    private RadioButton rdbDivision;
    @FXML
    private javafx.scene.control.TextField txtResultado;
       

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleGroup tg = new ToggleGroup();
        this.rdbSuma.setToggleGroup(tg);
        this.rdbResta.setToggleGroup(tg);
        this.rdbMult.setToggleGroup(tg);
        this.rdbDivision.setToggleGroup(tg);
    }  
   

    @FXML
    private void hacerOperacion(javafx.event.ActionEvent event) {
        try {
            int op1 = Integer.parseInt(this.txtOp1.getText());
            int op2 = Integer.parseInt(this.txtOp2.getText());

            Operaciones op = new Operaciones(op1, op2);

            if (this.rdbSuma.isSelected()) {
                this.txtResultado.setText(op.suma() + "");
            } else if (this.rdbResta.isSelected()) {
                this.txtResultado.setText(op.resta() + "");
            } else if (this.rdbMult.isSelected()) {
                this.txtResultado.setText(op.mult() + "");
            } else if (this.rdbDivision.isSelected()) {
                if (op2 == 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("El operando 2 no puede ser 0");
                    alert.showAndWait();
                } else {
                    this.txtResultado.setText(op.division() + "");
                }
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }
    
}
