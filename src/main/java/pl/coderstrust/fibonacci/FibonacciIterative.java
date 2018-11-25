package pl.coderstrust.fibonacci;

public class FibonacciIterative {
    static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder <= 0) {
            throw new IllegalArgumentException("fibonacciNumberInOrder argument must be greater than zero");
        }
        long fibonacciNumber = 1;
        long previousFibonacciNumber = 1;
        for (int i = 2; i <= fibonacciNumberInOrder; i++) {
            long temp = fibonacciNumber;
            fibonacciNumber += previousFibonacciNumber;
            previousFibonacciNumber = temp;
        }
        return fibonacciNumber;
    }
}
