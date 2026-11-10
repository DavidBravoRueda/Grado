package controlador;

// Fig. 24.33: AddressBookController.java
// Controller for the AddressBook app
import modelo.PersonQueries;
import modelo.Person;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controlador de la aplicación AddressBook.
 * Este controlador gestiona la interacción entre la interfaz gráfica y la base de datos
 *
 * @author [David]
 * @version 1.0
 */


public class AddressBookController {
   /**
    * ListView que muestra los nombres de los contactos.
    */
   @FXML private ListView<Person> listView; // displays contact names
   @FXML private TextField firstNameTextField;
   @FXML private TextField lastNameTextField;
   @FXML private TextField emailTextField;
   @FXML private TextField phoneTextField;
   @FXML private TextField findByLastNameTextField;

   /**
    * Objeto que interactúa con la base de datos.
    */
   // interacts with the database
   private final PersonQueries personQueries = new PersonQueries();

   /**
    * Lista de objetos Person que resultan de una consulta a la base de datos.
    */
   // stores list of Person objects that results from a database query
   private final ObservableList<Person> contactList = 
      FXCollections.observableArrayList();

   /**
    * Inicializa la aplicación.
    */
   // populate listView and set up listener for selection events
   public void initialize() {
      listView.setItems(contactList); // bind to contactsList
      getAllEntries(); // populates contactList, which updates listView
      /**
       * Cuando cambia la selección de ListView, se muestra la información del contacto seleccionado.
       */
      // when ListView selection changes, display selected person's data
      listView.getSelectionModel().selectedItemProperty().addListener(
         (observableValue, oldValue, newValue) -> {
            displayContact(newValue);
         }
      );     
   }

   // get all the entries from the database to populate contactList
   private void getAllEntries() {
      contactList.setAll(personQueries.getAllPeople()); 
      selectFirstEntry();
   }

    /**
     * Selecciona el primer elemento de la lista.
     */
   // select first item in listView
   private void selectFirstEntry() {
      listView.getSelectionModel().selectFirst();          
   }

   /**
    * @param person
    */
   // display contact information
   private void displayContact(Person person) {
      if (person != null) {
         firstNameTextField.setText(person.getFirstName());
         lastNameTextField.setText(person.getLastName());
         emailTextField.setText(person.getEmail());
         phoneTextField.setText(person.getPhoneNumber());
      }
      else {
         firstNameTextField.clear();
         lastNameTextField.clear();
         emailTextField.clear();
         phoneTextField.clear();
      }
   }

   /**
    * Añaade un nuevo contacto.
    */
   // add a new entry
   @FXML
   void addEntryButtonPressed(ActionEvent event) {
      int result = personQueries.addPerson(
         firstNameTextField.getText(), lastNameTextField.getText(), 
         emailTextField.getText(), phoneTextField.getText());                                     
      
      if (result == 1) {
         displayAlert(AlertType.INFORMATION, "Entry Added", 
            "New entry successfully added.");
      }
      else {
         displayAlert(AlertType.ERROR, "Entry Not Added", 
            "Unable to add entry.");
      }
      
      getAllEntries();
   }

   /**
    * Actualiza la información de un contacto.
    */
   // find entries with the specified last name
   @FXML
   void findButtonPressed(ActionEvent event) {
      List<Person> people = personQueries.getPeopleByLastName(
         findByLastNameTextField.getText() + "%");

      if (people.size() > 0) { // display all entries
         contactList.setAll(people);
         selectFirstEntry();
      }
      else {
         displayAlert(AlertType.INFORMATION, "Lastname Not Found", 
            "There are no entries with the specified last name.");
      }
   }

   /**
    *
    * @param event
    */
   // browse all the entries
   @FXML
   void browseAllButtonPressed(ActionEvent event) {
      getAllEntries();
   }

    /**
     * Alerta de información.
     */
   // display an Alert dialog
   private void displayAlert(
      AlertType type, String title, String message) {
      Alert alert = new Alert(type);
      alert.setTitle(title);
      alert.setContentText(message);
      alert.showAndWait();
   }
}

