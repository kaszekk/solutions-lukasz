package pl.coderstrust.fibonacci;

public class FibonacciIterative {
    static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            throw new IllegalArgumentException("fibonacciNumberInOrder argument must be greater than zero");
        }
        long[] fib = {1, 1, 1};
        for (int i = 2; i <= fibonacciNumberInOrder; i++) {
            fib[2] = fib[1] + fib[0];
            fib[0] = fib[1];
            fib[1] = fib[2];
        }
        return fib[2];
    }
}
