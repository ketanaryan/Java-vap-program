import java.util.Scanner;
public class Calculate{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number");
        int a = input.nextInt();
        System.out.println("Enter second number");
        int b = input.nextInt();
        System.out.println("Enter the operator(+,-,/,*)");
        String operation = input.next();

        switch(operation){
            case "+":
                System.out.println("Addition result is "+(a+b));
                break ;
            case "-":
                System.out.println("Subtraction reuslt is "+(a-b));
                break;
            case "*":
                System.out.println("multiplication result is "+(a*b));
                break;
            case "/":
                if(b!=0){
                    System.out.println("Divisible result is "+(a/b));}
                    else{
                        System.out.println("Enter valid value");
                    }
                break;
                default :
                System.out.println("Enter valid values");
                
        }

    }
}