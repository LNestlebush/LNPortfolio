// Create a program that allows for input files with passenger name, seat number, and seat type
// Allows changing information and exporting of updated information via text file



import java.io.*;
import java.util.*;

public class LNAirlineReservation {
    private static final int CAPACITY = 100; // capacity of the arrays/plane in this case
    private static String[] passengerNames = new String[CAPACITY];
    private static int[] seatNumbers = new int[CAPACITY];
    private static char[] seatTypes = new char[CAPACITY];
    private static int passengerCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeArrays();
        readPassengerInfoFile("passengerInfo.txt");


        //Creates a user menu to determine what to run next
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Book a Seat");
            System.out.println("2. Adjust Passenger Information");
            System.out.println("3. Export Passenger Information");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    bookASeat(scanner);
                    break;
                case 2:
                    adjustPassengerInformation(scanner);
                    break;
                case 3:
                    exportPassengerInformation("updatedPassengerInfo.txt");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    //Creates arrays used to store passenger info
    private static void initializeArrays() {
        for (int i = 0; i < CAPACITY; i++) {
            passengerNames[i] = "";
            seatNumbers[i] = 0;
            seatTypes[i] = ' ';
        }
    }


    //Reads info file and places passengers into array
    private static void readPassengerInfoFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null && passengerCount < CAPACITY) {
                String[] parts = line.split(",");
                passengerNames[passengerCount] = parts[0].trim();
                seatNumbers[passengerCount] = Integer.parseInt(parts[1].trim());
                seatTypes[passengerCount] = parts[2].trim().charAt(0);
                passengerCount++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    //User inputs information for booking a new seat
    private static void bookASeat(Scanner scanner) {
        if (passengerCount >= CAPACITY) {
            System.out.println("No more seats available.");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Enter seat number: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter seat type (A: First Class, B: Business Class, C: Economy): ");
        char seatType = scanner.nextLine().charAt(0);

        passengerNames[passengerCount] = name;
        seatNumbers[passengerCount] = seatNumber;
        seatTypes[passengerCount] = seatType;
        passengerCount++;
        System.out.println("Seat booked successfully.");
    }

    //Searches for the name of passenger and returns index of given passenger
    private static int findPassengerIndexByName(String name) {
        for (int i = 0; i < passengerCount; i++) {
            if (passengerNames[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }



    //User can change seat number/type
    private static void adjustPassengerInformation(Scanner scanner) {
        System.out.print("Enter the passenger name to adjust: ");
        String name = scanner.nextLine();
        int index = findPassengerIndexByName(name);

        if (index == -1) {
            System.out.println("Passenger not found.");
            return;
        }

        System.out.print("Enter new seat number: ");
        seatNumbers[index] = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        System.out.print("Enter new seat type (A: First Class, B: Business Class, C: Economy): ");
        seatTypes[index] = scanner.nextLine().charAt(0);
        System.out.println("Passenger information updated successfully.");
    }



    //Exports new passenger info to a new txt file
    private static void exportPassengerInformation(String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < passengerCount; i++) {
                pw.println(passengerNames[i] + "," + seatNumbers[i] + "," + seatTypes[i]);
            }
            System.out.println("Passenger information exported successfully.");
        } catch (IOException e) {
            System.out.println("Error exporting file: " + e.getMessage());
        }
    }
}
