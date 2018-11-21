package pl.coderstrust.fibonacci;

public class FibonacciIterative {
    static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            throw new IllegalArgumentException("Cannot accept negative argument");
        }
        long[] fib = {1, 1};
        long result = 1;
        for (int i = 2; i <= fibonacciNumberInOrder; i++) {
            result = fib[1] + fib[0];
            fib[0] = fib[1];
            fib[1] = result;
        }
        return result;
    }
}
