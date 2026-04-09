public class Armstrong {
    public static boolean isArmstrong(int n) {
        int original = n;
        int sum = 0;
        int digits = String.valueOf(n).length();
        while (n > 0) {
            int digit = n % 10;
            sum = sum + (int) Math.pow(digit, digits);
            n /= 10;
        }
        return sum == original;
    }
    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
    }
}
