package pl.coderstrust.fibonacci;

public class FibonacciRecursive {
    static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder <= 0) {
            throw new IllegalArgumentException("fibonacciNumberInOrder argument must be greater than zero");
        }
        if (fibonacciNumberInOrder <= 2) {
            return 1L;
        } else {
            return fibonacci(fibonacciNumberInOrder - 1) + fibonacci(fibonacciNumberInOrder - 2);
        }
    }
}
