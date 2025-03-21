import java.util.Scanner;
import java.math.*;

public class LargeFactorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
         System.out.print("Enter an integer: "); 
      int n = input.nextInt();
      System.out.println(n +"! is \n" + factorial(n));
    }


 // Recursive factorial method
 public static BigInteger factorial(long n) {
    if (n == 0 || n == 1) //Base case
       return BigInteger.ONE;
  
    return new BigInteger(n + "").multiply(factorial(n - 1)); //Recursive case
  } 

}

