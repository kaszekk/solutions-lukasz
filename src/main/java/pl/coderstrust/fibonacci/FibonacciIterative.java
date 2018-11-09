package pl.coderstrust.fibonacci;

public class FibonacciIterative {
    public static long fibonacci(int fibonacciNumberInOrder) {
        long[] fib = {1, 1};
        long result = 1;
        for (int i = 3; i <= fibonacciNumberInOrder; i++) {
            fibValue = fib[1] + fib[0];
            fib[0] = fib[1];
            fib[1] = fibValue;
        }
        return fibValue;
    }
}
