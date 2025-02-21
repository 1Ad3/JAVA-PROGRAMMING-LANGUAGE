import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();

        int num1 = 0, num2 = 1;
        System.out.print("Fibonacci Series: " + num1 + ", " + num2);

        for (int i = 2; i < terms; i++) {
            int nextTerm = num1 + num2;
            System.out.print(", " + nextTerm);
            num1 = num2;
            num2 = nextTerm;
        }
        sc.close();
    }
}
