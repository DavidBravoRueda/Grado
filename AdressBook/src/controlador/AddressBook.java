package controlador;

// Fig. X: AddressBook.java
// Main application class that loads and displays the AddressBook's GUI.

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación AddressBook. 
 * Esta clase gestiona la interfaz de usuario y los eventos asociados al libro de direcciones.
 * 
 * @author [David]
 * @version 1.0
 */

public class AddressBook extends Application {
    /**
     * Método que inicia la aplicación.
     *
     * @param stage
     * @throws Exception
     */
   @Override
   public void start(Stage stage) throws Exception {
      Parent root = 
         FXMLLoader.load(getClass().getResource("AddressBook.fxml"));
      
      Scene scene = new Scene(root);
      stage.setTitle("Address Book");
      stage.setScene(scene);
      stage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}
