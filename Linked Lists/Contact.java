import java.util.Scanner;
import java.util.LinkedList;


// Object class that represents a contact in a phonebook
// A contact has a first name, last name, phone number, address, city, and email
// A contact can be modified to update the phone number, address, city, and email
// A contact can be displayed to show the first name, last name, phone number, address, city, and email

class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String email;

    // Constructor to create a contact with a first name, last name, phone number, address, city, and email
    public Contact(String firstName, String lastName, String phoneNumber, String address, String city, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.email = email;
    }


    // Getters and setters for the contact's first name, last name, phone number, address, city, and email
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getEmail() { return email; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setEmail(String email) { this.email = email; }


    // Display the contact's first name, last name, phone number, address, city, and email
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\nPhone: " + phoneNumber +
               "\nAddress: " + address + ", " + city + "\nEmail: " + email + "\n";
    }
}