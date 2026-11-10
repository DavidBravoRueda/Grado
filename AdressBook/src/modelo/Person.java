package modelo;

// Fig. 24.31: Person.java
// Person class that represents an entry in an address book.

/**
 * Clase que representa una entrada en un libro de direcciones.
 * Esta clase contiene los datos de una persona, incluyendo su nombre,
 * dirección de correo electrónico y número de teléfono.
 *
 * @author [David]
 * @version 1.0
 */
public class Person {
   private int addressID;
   private String firstName;
   private String lastName;
   private String email;
   private String phoneNumber;

   /**
    * Constructor de la clase.
    */
   // constructor
   public Person() {}

   /**
    * @param addressID
    * @param firstName
    * @param lastName
    * @param email
    * @param phoneNumber
    */
   // constructor
   public Person(int addressID, String firstName, String lastName, 
      String email, String phoneNumber) {
      this.addressID = addressID;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.phoneNumber = phoneNumber;
   }

   /**
    * sets the addressID
    */
   // sets the addressID
   public void setAddressID(int addressID) {this.addressID = addressID;}

   /**
    * @return addressID
    */
   // returns the addressID 
   public int getAddressID() {return addressID;}

   /**
    * sets the firstName
    */
   // sets the firstName
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    * @return firstName
    */
   // returns the first name 
   public String getFirstName() {return firstName;}

    /**
     * sets the lastName
     */
   // sets the lastName
   public void setLastName(String lastName) {this.lastName = lastName;}

    /**
     * @return lastName
     */
   // returns the last name 
   public String getLastName() {return lastName;}

   /**
    * sets the email
    */
   // sets the email address
   public void setEmail(String email) {this.email = email;}

   /**
    * @return email
    */
   // returns the email address
   public String getEmail() {return email;}

    /**
     * sets the phoneNumber
     */
   // sets the phone number
   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   } 

    /**
     * @return phoneNumber
     */
   // returns the phone number
   public String getPhoneNumber() {return phoneNumber;}

    /**
     * @return string representation of Person's name
     */
   // returns the string representation of the Person's name
   @Override
   public String toString() 
      {return getLastName() + ", " + getFirstName();}
}

