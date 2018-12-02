package pl.coderstrust.fibonacci;

public class FibonacciIterative {
    static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder <= 0) {
            throw new IllegalArgumentException("fibonacciNumberInOrder argument must be greater than zero");
        }
        long[] fib = {1, 1, 2};
        if (fibonacciNumberInOrder <= 2) {
            return fib[fibonacciNumberInOrder - 1];
        }
        for (int i = 4; i <= fibonacciNumberInOrder; i++) {
            fib[0] = fib[2];
            fib[2] += fib[1];
            fib[1] = fib[0];
            fib[0] = fib[2] - fib[1];
        }
        return fib[2];
    }
}
