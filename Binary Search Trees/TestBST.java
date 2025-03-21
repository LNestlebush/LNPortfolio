//Test class for BSTManager.java


import java.util.Scanner;

public class TestBST {
    public static void main(String[] args) {
        BSTManager bst = new BSTManager();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println();
            System.out.println("1. Add Member\n2. Remove Member\n3. Search Member\n4. Display In-Order\n5. Display Pre-Order\n6. Display Post-Order\n7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    
                    bst.add(new Member(id, firstName, lastName, address, city));
                    break;
                case 2:
                    System.out.print("Enter ID to remove: ");
                    int removeId = scanner.nextInt();
                    bst.remove(removeId);
                    break;
                    case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();
                    Member foundMember = bst.search(searchId);
                    System.out.println(foundMember != null ? "Member found: " + foundMember : "Member not found.");
                    break;
                case 4:
                    System.out.println("In-Order Traversal:");
                    bst.inOrder();
                    break;
                case 5:
                    System.out.println("Pre-Order Traversal:");
                    bst.preOrder();
                    break;
                case 6:
                    System.out.println("Post-Order Traversal:");
                    bst.postOrder();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
