import java.util.Scanner;

public class JavaBasics {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number:");
        int number = scanner.nextInt();
        for (int i = 2; i < number - 1;) {
            if (number % i == 0) {
                System.out.println("Not a prime number");
                break;
            } else {
                System.out.println("Prime number");
                break;
            }
        }
        scanner.close();
    }
}