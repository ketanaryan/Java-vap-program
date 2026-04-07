import java.util.Scanner;
public class Swapnumbers{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first number");
        int a = input.nextInt();
        System.out.println("Enter your second number");
        int b= input.nextInt();
       
        System.out.println("before swasp a is"+ a +"before swap b is" + b);
        a = a +b;
        b = a-b;
        a = a-b;
        System.out.println("After swap" + a + "b is after swap" + b);
        input.close();
    }
    
}