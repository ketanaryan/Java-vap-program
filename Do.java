import java.util.Scanner;
public class Do {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome do you want to print yes or no");
        String input = sc.nextLine();
        do{
           
            System.out.println("Welcome do you want to print yes or no");
            input = sc.nextLine();
            System.out.println("do you want to prin again");
        } while(input.equals("yes"));
    

    }
}
