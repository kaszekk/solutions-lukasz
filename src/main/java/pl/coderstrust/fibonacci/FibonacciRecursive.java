package pl.coderstrust.fibonacci;

public class FibonacciRecursive {
    static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            throw new IllegalArgumentException("Cannot accept negative argument");
        }
        if (fibonacciNumberInOrder == 0 || fibonacciNumberInOrder == 1) {
            return 1L;
        } else {
            return fibonacci(fibonacciNumberInOrder - 1) + fibonacci(fibonacciNumberInOrder - 2);
        }
    }
}
