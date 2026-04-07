import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter marks for Physics, Chemistry, Biology, Mathematics, and Computer:");
        double p = input.nextDouble();
        double c = input.nextDouble();
        double b = input.nextDouble();
        double m = input.nextDouble();
        double comp = input.nextDouble();

        double percentage = (p + c + b + m + comp) / 5.0;

        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 90) {
            System.out.println("Grade A");
        } else if (percentage >= 80) {
            System.out.println("Grade B");
        } else if (percentage >= 70) {
            System.out.println("Grade C");
        } else if (percentage >= 60) {
            System.out.println("Grade D");
        } else if (percentage >= 40) {
            System.out.println("Grade E");
        } else {
            System.out.println("Grade F");
        }

        input.close();
    }
}