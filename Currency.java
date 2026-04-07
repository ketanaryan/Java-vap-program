import java.util.Scanner;

public class Currency{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount");
        int amount = input.nextInt();

        int notes200 = amount / 2000;
         int remainder = amount % 2000;
        int notes500 = remainder / 500;
        remainder = remainder % 500;
        int notes100 = remainder / 100;
        remainder = remainder % 100;
        int notes50 = remainder / 50;
        remainder = amount % 50;
        int notes10 = remainder / 10;
     

        System.out.println("notes: " + notes200);
        System.out.println("notes: " + notes500);
        System.out.println("notes: " + notes100);
        System.out.println("notes" +notes50);
        System.out.println("notes "+ notes10);
        
    
    }
}