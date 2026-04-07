import java.util.Scanner;
public class Divisibilty {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = input.nextInt();

        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("Fizzbuzz");
        } else if (number % 3 == 0) {
            System.out.println("Buzz");
        } else if (number % 5 == 0) {
            System.out.println("Fizz");
        } else {
            System.out.println("Not divisible by either 3 or 5");
        }
    }
}
