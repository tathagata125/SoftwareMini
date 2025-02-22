import java.util.Scanner;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Scientific Calculator Menu:");
            System.out.println("1. Square root function - √x");
            System.out.println("2. Factorial function - x!");
            System.out.println("3. Natural logarithm (base e) - ln(x)");
            System.out.println("4. Power function - x^b");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    double x = scanner.nextDouble();
                    System.out.println("Square root of " + x + " is " + Math.sqrt(x));
                    break;
                case 2:
                    System.out.print("Enter a number: ");
                    int n = scanner.nextInt();
                    System.out.println("Factorial of " + n + " is " + factorial(n));
                    break;
                case 3:
                    System.out.print("Enter a number: ");
                    x = scanner.nextDouble();
                    System.out.println("Natural logarithm of " + x + " is " + Math.log(x));
                    break;
                case 4:
                    System.out.print("Enter the base number (x): ");
                    x = scanner.nextDouble();
                    System.out.print("Enter the exponent (b): ");
                    double b = scanner.nextDouble();
                    System.out.println(x + " raised to the power of " + b + " is " + Math.pow(x, b));
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
