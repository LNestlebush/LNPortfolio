import java.util.Scanner;
import java.util.LinkedList;


//Test class that uses PhonebookManager to manage contacts
//and display a menu to interact with the phonebook
//The user can add, remove, modify, and display contacts
//The user can add a contact by entering the first name, last name, phone number, address, city, and email
//The user can remove a contact by entering the first name and last name
//The user can modify a contact by entering the first name and last name
//The user can display all contacts in the phonebook
//The user can exit the phonebook


public class PhonebookTest {
    public static void main(String[] args) {
        PhonebookManager manager = new PhonebookManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("Phonebook Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Modify Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                // Add Contact
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    manager.addContact(new Contact(firstName, lastName, phoneNumber, address, city, email));
                    break;
                
                // Remove Contact
                case 2:
                    System.out.print("Enter First Name of Contact to Remove: ");
                    String removeFirstName = scanner.nextLine();
                    System.out.print("Enter Last Name of Contact to Remove: ");
                    String removeLastName = scanner.nextLine();
                    manager.removeContact(removeFirstName, removeLastName);
                    break;

                // Modify Contact
                case 3:
                    System.out.print("Enter First Name of Contact to Modify: ");
                    String modifyFirstName = scanner.nextLine();
                    System.out.print("Enter Last Name of Contact to Modify: ");
                    String modifyLastName = scanner.nextLine();
                    manager.modifyContact(modifyFirstName, modifyLastName, scanner);
                    break;

                // Display Contacts
                case 4:
                    manager.displayContacts();
                    break;

                // Exit
                case 5:
                    System.out.println("Exiting Phonebook. Goodbye!");
                    break;

                // Invalid choice
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}