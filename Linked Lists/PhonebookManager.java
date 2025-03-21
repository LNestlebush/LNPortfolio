import java.util.Scanner;
import java.util.LinkedList;


// Manager class that manages contacts in a phonebook
// The manager can add, remove, modify, and display contacts


class PhonebookManager {
    private LinkedList<Contact> contacts = new LinkedList<>();

    // Add a contact to the phonebook 
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.\n");
    }

    // Remove a contact from the phonebook
    public void removeContact(String firstName, String lastName) {
        Contact toRemove = null;
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && 
                contact.getLastName().equalsIgnoreCase(lastName)) {
                toRemove = contact;
                break;
            }
        }
        if (toRemove != null) {
            contacts.remove(toRemove);
            System.out.println("Contact removed successfully.\n");
        } else {
            System.out.println("Contact not found.\n");
        }
    }

    // Modify a contact in the phonebook
    // Asks the user for new phone number, address, city, and email
    public void modifyContact(String firstName, String lastName, Scanner scanner) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && 
                contact.getLastName().equalsIgnoreCase(lastName)) {
                
                System.out.println("Enter new phone number (or press Enter to keep current): ");
                String newPhone = scanner.nextLine();
                if (!newPhone.isEmpty()) contact.setPhoneNumber(newPhone);
                
                System.out.println("Enter new address (or press Enter to keep current): ");
                String newAddress = scanner.nextLine();
                if (!newAddress.isEmpty()) contact.setAddress(newAddress);
                
                System.out.println("Enter new city (or press Enter to keep current): ");
                String newCity = scanner.nextLine();
                if (!newCity.isEmpty()) contact.setCity(newCity);
                
                System.out.println("Enter new email (or press Enter to keep current): ");
                String newEmail = scanner.nextLine();
                if (!newEmail.isEmpty()) contact.setEmail(newEmail);
                
                System.out.println("Contact modified successfully.\n");
                return;
            }
        }
        System.out.println("Contact not found.\n");
    }

    // Display all contacts in the phonebook
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.\n");
        } else {
            System.out.println("Phonebook Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}