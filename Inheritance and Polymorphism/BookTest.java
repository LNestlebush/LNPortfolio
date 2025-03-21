//This program asks the user if the book is a textbook, then asks for the book name and number of pages. 
//If the book is a textbook, it asks for the grade level.
//If the grade level is not between 1 and 12, it throws an exception and prints an error message.
//The program then displays the book information.

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Asks user if the book is a textbook then trims and converts to lowercase
        System.out.print("Is the book a textbook? (yes/no): ");
        String isTextbook = scanner.nextLine().trim().toLowerCase();
        
        //Asks user for book name and stores in the name variable
        System.out.print("Enter the book name: ");
        String name = scanner.nextLine();
        
        //Asks user for number of pages and stores in the pages variable
        System.out.print("Enter the number of pages: ");
        int pages = scanner.nextInt();

        try {
            //If the book is a textbook, asks user for grade level and stores in the gradeLevel variable
            if (isTextbook.equals("yes")) {
                System.out.print("Enter the grade level (1-12): ");
                int gradeLevel = scanner.nextInt();
                Textbook textbook = new Textbook(name, pages, gradeLevel);
                textbook.displayInfo();
            } else {
                //If the book is not a textbook, creates a novel object
                Novel novel = new Novel(name, pages);
                novel.displayInfo();
            }
            //If the grade level is not between 1 and 12, catches the exception and prints the error message
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}