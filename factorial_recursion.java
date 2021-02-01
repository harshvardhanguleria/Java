import java.util.*;
public class factorial_recursion {
    static int factorial(int n) {
        if (n > 1) {
            return (n * factorial(n - 1));
        }
        else {
            return (n);
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = factorial(n);  
        System.out.println(result);
        scanner.close();
    }
}