import java.util.Scanner;
public class Reverse {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = input.nextInt();
        int sum = 0;

        while(number>0){
            int digit = number % 10;
             sum = sum * 10 + digit ;
            number /= 10;
        }
        System.out.println("The reverse of the number is: " + sum);

    }
}
