package pl.coderstrust.pascal;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<String> getPascalTriangle(int numberOfRows) {
        if (numberOfRows <= 0) {
            throw new IllegalArgumentException("Number of rows must be greater than zero");
        }
        List<String> pascalTriangle = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < numberOfRows; row++) {
            result.delete(0, result.length());
            int nodeValue;
            for (int col = 0; col <= row; col++) {
                nodeValue = factorial(row) / (factorial(col) * factorial(row - col));
                result.append(String.format("%d ", nodeValue));
            }
            pascalTriangle.add(result.toString());
        }
        return pascalTriangle;
    }

    private static int factorial(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }
}
