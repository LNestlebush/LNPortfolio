import java.util.Arrays;

//Uses bubble sort to sort an array of integers given by the user

public class BubbleSortManager {
    public static void bubbleSort(int[] arr) {
        //Sets the length of the array to n
        //Initializes a boolean variable swapped to false
        int n = arr.length;
        boolean swapped;
        
        //Loops through the array n-1 times
        //Loops through the array from the beginning to the end
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                //If the current element is greater than the next element
                //Swaps the current element with the next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps happened, the array is already sorted
            if (!swapped) break;
        }
    }
}
