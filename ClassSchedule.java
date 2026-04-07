
import java.util.Scanner;

public class ClassSchedule {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the day");
        String day = input.nextLine();

        switch(day){
            case "monday":
            case "wednesday":
            System.out.println("basketball");
            break;

            case "tuesday":
            case "friday":
            System.out.println("Tennis");
            break;

            case "Thursday":
                System.out.println("Cricket");
                break;

            case "saturday":
             System.out.println("Exerciet");
             break;


            case "Sunday":
                System.out.println("holdiay");
                break;

            default :
            System.out.println("Enter valid value");
            break;
        }
            
    }
    

}
