package pl.coderstrust.isThatFibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibonacciChecker {
    private static Map<Long, Boolean> cache = new HashMap<>();

    public static boolean fibonacciChecker(Long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Argument cannot be negative");
        }
        if (cache.containsKey(number)) {
            return cache.get(number);
        } else if ((isPerfectSquare(5 * number * number - 4) | isPerfectSquare(5 * number * number + 4))) {
            cache.put(number, true);
            return true;
        } else {
            cache.put(number, false);
            return false;
        }
    }

    private static boolean isPerfectSquare(long number) {
        double sqrt = Math.sqrt(number);
        return sqrt == (long) sqrt;
    }
}
