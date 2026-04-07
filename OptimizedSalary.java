import java.util.Scanner;

public class OptimizedSalary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter gender: ");
        String gender = input.nextLine().trim().toLowerCase();

        System.out.print("Enter experience: ");
        int experience = input.nextInt();
        input.nextLine(); 

        System.out.print("Enter qualification: ");
        String qualification = input.nextLine().trim().toLowerCase();

        int salary = 0;
        String key = gender + "-" + qualification;

        switch (key) {
            case "male-postgraduate":
                salary = (experience > 10) ? 150000 : 10000;
                break;
            case "female-postgraduate":
                salary = (experience > 10) ? 120000 : 8000;
                break;
            case "male-graduate":
                salary = (experience > 10) ? 10000 : 7000;
                break;
            case "female-graduate":
                salary = (experience > 10) ? 90000 : 7000;
                break;
            default:
                System.out.println("Invalid input data");
                return;
        }

        System.out.println("Your salary is: " + salary);
        input.close();
    }
}