package modelo;

// Fig. 24.31: PersonQueries.java
// PreparedStatements used by the Address Book application.
import modelo.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase que realiza consultas a la base de datos AddressBook.
 * Esta clase contiene métodos para obtener todas las entradas de la base de datos,
 * buscar entradas por apellido y agregar una nueva entrada.
 *
 * @author [David]
 * @version 1.0
 */

public class PersonQueries {

   /**
    * URL de la base de datos.
    */
   private static final String URL = "jdbc:derby:AddressBook";
   private static final String USERNAME = "deitel";
   private static final String PASSWORD = "deitel";

   /**
    * @param connection
    * @param selectAllPeople
    * @param selectPeopleByLastName
    * @param insertNewPerson
    */
   private Connection connection; // manages connection
   private PreparedStatement selectAllPeople;       
   private PreparedStatement selectPeopleByLastName;
   private PreparedStatement insertNewPerson;       

   /**
    * Constructor de la clase.
    */
   // constructor
   public PersonQueries() {
      try {
         connection = 
            DriverManager.getConnection(URL, USERNAME, PASSWORD);

         /**
          * Prepara las consultas a la base de datos.
          */
         // create query that selects all entries in the AddressBook 
         selectAllPeople = connection.prepareStatement(
            "SELECT * FROM Addresses ORDER BY LastName, FirstName");

         /**
          * Crea una consulta que selecciona las entradas con apellidos que comienzan
          * con los caracteres especificados.
          */
         // create query that selects entries with last names 
         // that begin with the specified characters 
         selectPeopleByLastName = connection.prepareStatement(        
            "SELECT * FROM Addresses WHERE LastName LIKE ? " + 
            "ORDER BY LastName, FirstName");

         /**
          * Crea una consulta que agrega una nueva entrada a la base de datos.
          */
         // create insert that adds a new entry into the database
         insertNewPerson = connection.prepareStatement(         
            "INSERT INTO Addresses " +                           
            "(FirstName, LastName, Email, PhoneNumber) " +     
            "VALUES (?, ?, ?, ?)");                           
      } 
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
         System.exit(1);
      } 
   }

   /**
    *
    * @return
    */
   // select all of the addresses in the database
   public List<Person> getAllPeople() {
      // executeQuery returns ResultSet containing matching entries
      try (ResultSet resultSet = selectAllPeople.executeQuery()) {
         List<Person> results = new ArrayList<Person>();
         
         while (resultSet.next()) {
            results.add(new Person(
               resultSet.getInt("AddressID"),
               resultSet.getString("FirstName"),
               resultSet.getString("LastName"),
               resultSet.getString("Email"),
               resultSet.getString("PhoneNumber")));
         } 

         return results;
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();         
      }
      
      return null;
   }

   /**
    *
    * @param lastName
    * @return
    */
   // select person by last name
   public List<Person> getPeopleByLastName(String lastName) {
      try {
         selectPeopleByLastName.setString(1, lastName); // set last name
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
         return null;
      }

      /**
       * Ejecuta la consulta y devuelve un ResultSet que contiene las entradas coincidentes.
       */
      // executeQuery returns ResultSet containing matching entries
      try (ResultSet resultSet = selectPeopleByLastName.executeQuery()) {
         List<Person> results = new ArrayList<Person>();

         while (resultSet.next()) {
            results.add(new Person(
               resultSet.getInt("addressID"),
               resultSet.getString("FirstName"),
               resultSet.getString("LastName"),
               resultSet.getString("Email"),
               resultSet.getString("PhoneNumber")));
         } 

         return results;
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
         return null;
      } 
   }

   /**
    *
    * @param firstName
    * @param lastName
    * @param email
    * @param phoneNumber
    * @return
    */
   // add an entry
   public int addPerson(String firstName, String lastName, 
      String email, String phoneNumber) {

      /**
       * Inserta la nueva entrada; devuelve el número de filas actualizadas.
       */
      // insert the new entry; returns # of rows updated
      try {
         /**
          * Establece los parámetros.
          */
         // set parameters
         insertNewPerson.setString(1, firstName);
         insertNewPerson.setString(2, lastName);
         insertNewPerson.setString(3, email);
         insertNewPerson.setString(4, phoneNumber);  

         return insertNewPerson.executeUpdate();         
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
         return 0;
      }
   }

   /**
    * Cierra la conexión a la base de datos.
    */
   // close the database connection
   public void close() {
      try {
         connection.close();
      } 
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
      } 
   }
} 


