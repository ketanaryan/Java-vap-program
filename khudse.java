import java.util.Scanner;

public class khudse {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = input.nextInt();

        if( number % 3==0 && number % 5== 0){
            System.out.println("number is divisble by both");
        }
        else if (number % 3 == 0 || number % 5 == 0){
            System.out.println("either divisvle by 3 or 5");
        }
    }

}
