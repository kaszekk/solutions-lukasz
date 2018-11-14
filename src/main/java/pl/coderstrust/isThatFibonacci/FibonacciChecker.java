package pl.coderstrust.isThatFibonacci;

import java.util.HashMap;

public class FibonacciChecker {
    /*public static void main(String[] args) {
        for (long i = 0; i <= 1000; i++) {
            if (fibonacciChecker(i)) {
                System.out.println(i + " is Fibo");
            }
        }
    }*/

    private static HashMap<Long, Boolean> cache = new HashMap<>();

    public static boolean fibonacciChecker(Long number) {

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
