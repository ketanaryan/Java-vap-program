import java.util.Scanner;
public class Salary {
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);
        System.out.println("Enter your gender");
        String gender =input.nextLine();
        System.out.println("Enter your Experince");
        int Experince = input.nextInt();
        input.nextLine();
        System.out.println("Enter your qualification");
        String Qualifcation = input.nextLine();
  

        if(gender.equalsIgnoreCase("male")){
            if(Experince > 10 && Qualifcation.equals("postgraduate")){
                System.out.println("Your salary is 150000");
            }
            else if(Experince > 10 && Qualifcation.equals("graduate")){
                System.out.println("your salary is 10000");

            }
            else if(Experince <10 && Qualifcation.equals("postgraduate")){
                System.out.println("your slaary is 10000");
            }
            else if(Experince <10 && Qualifcation.equals("graduate")){
                System.out.println("your slaary is 7000");
            }
           
        }
         if(gender.equalsIgnoreCase("female")){
            if(Experince > 10 && Qualifcation.equals("postgraduate")){
                System.out.println("Your salary is 120000");
            }
            else if(Experince > 10 && Qualifcation.equals("graduate")){
                System.out.println("your salary is 90000");

            }
            else if(Experince <10 && Qualifcation.equals("postgraduate")){
                System.out.println("your slaary is 8000");
            }
            else if(Experince <10 && Qualifcation.equals("graduate")){
                System.out.println("your slaary is 7000");
            }
           
        }
    }
    
}
