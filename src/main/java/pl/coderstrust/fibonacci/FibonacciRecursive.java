package pl.coderstrust.fibonacci;

public class FibonacciRecursive {
    public static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder == 1 || fibonacciNumberInOrder == 2) {
            return 1L;
        } else {
            return fibonacci(fibonacciNumberInOrder - 1) + fibonacci(fibonacciNumberInOrder - 2);
        }
    }
}
