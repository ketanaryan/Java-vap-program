import java.util.Scanner;
public class Sumdigits {
            public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int number = input.nextInt();
            int tempnumber = Math.abs(number);
            int sum = 0;

        while (tempnumber > 0) {
            int digit = tempnumber % 10; 
            sum = sum + digit; 
            tempnumber /= 10; 
        }

        System.out.println("The sum of the digits is: " + sum);
    }
}
