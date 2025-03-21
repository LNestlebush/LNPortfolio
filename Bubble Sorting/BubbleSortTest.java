import java.util.Scanner;
import java.util.Arrays;

//Asks the user to enter the number of elements and the elements
//Sorts the elements using bubble sort
//Prints the original and sorted arrays

public class BubbleSortTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Asks user to enter the number of elements and stores it in n
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        //Creates an array of size n
        //Asks user to enter the elements and stores them in the array
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        //Prints the original array
        System.out.println("Original array: " + Arrays.toString(arr));
        
        //Sorts the array using bubble sort
        BubbleSortManager.bubbleSort(arr);
        
        //Prints the sorted array
        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        scanner.close();
    }
}
