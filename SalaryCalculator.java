import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Basic Salary: ");
        double basic = input.nextDouble();

        System.out.print("Enter Current Year: ");
        int currentYear = input.nextInt();

        System.out.print("Enter Joining Year: ");
        int joiningYear = input.nextInt();

        double hra, da;
        double bonus = 0;

        if (basic <= 10000) {
            hra = basic * 0.20;
            da = basic * 0.80;
        } else if (basic <= 20000) {
            hra = basic * 0.25;
            da = basic * 0.90;
        } else {
            hra = basic * 0.30;
            da = basic * 0.95;
        }

        int yearsOfService = currentYear - joiningYear;
        if (yearsOfService > 3) {
            bonus = 2500;
        }

        double grossSalary = basic + hra + da + bonus;

        System.out.println("---------------------------");
        System.out.println("Basic Salary: " + basic);
        System.out.println("HRA: " + hra);
        System.out.println("DA: " + da);
        System.out.println("Bonus: " + bonus);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("---------------------------");

        input.close();
    }
}