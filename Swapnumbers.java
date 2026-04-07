public class Swapnumbers {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.println("Before swapping: a = " + a + ", b = " + b);

        a = a + b; // a ab 30 ban gaya (10 + 20)
        b = a - b; // b ab 10 ban gaya (30 - 20) -> Original 'a' mil gaya
        a = a - b; // a ab 20 ban gaya (30 - 10) -> Original 'b' mil gaya
        System.out.println("After swapping: a = " + a + ", b = " + b);
    }
    
}
