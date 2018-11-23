package pl.coderstrust.isThatFibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibonacciChecker {
    private Map<Long, Boolean> cache = new HashMap<>();

    boolean isFibonacciNumber(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }
        if (cache.containsKey(number)) {
            return cache.get(number);
        }
        long formula1 = 5 * number * number - 4;
        long formula2 = 5 * number * number + 4;
        boolean isFibonacci = isPerfectSquare(formula1) || isPerfectSquare(formula2);
        cache.put(number, isFibonacci);
        return isFibonacci;
    }

    private boolean isPerfectSquare(long number) {
        double sqrt = Math.sqrt(number);
        return sqrt == (long) sqrt;
    }
}
